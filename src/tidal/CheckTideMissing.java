package tidal;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import common_pg.Props;
import redis.clients.jedis.Jedis;

public class CheckTideMissing {

	static Logger log = LoggerFactory.getLogger(CheckTideMissing.class);
	static Jedis jedis;
	static DB db = DB.getInstance();
	static List<String> keys = new ArrayList<String>();

	public static void main(String[] args) {
		Date startProgramTime = Calendar.getInstance().getTime();

		jedis = new Jedis(Props.redisHost, Integer.parseInt(Props.redisPort));
//		jedis = new Jedis("k8.epd.gov.hk", Integer.parseInt(Props.redisPort));
		
		List<String> urls = processArchiveUrls();
		if (urls != null && !urls.isEmpty()) {
			int count = 0;

			// TODO

			for (String url : urls) {
				// https://api.data.gov.hk/v1/historical-archive/get-file?url=https%3A%2F%2Ftide1.hydro.gov.hk%2Fhotide%2FOpenData%2FAll_en.csv&time=20220112-1717
				log.info(url);

				// BatchDownload.downloadTidal(url);

				// ----------

				// collect lines of csv data into sList
				List<String> sList = new ArrayList<>();
				URL website;
				BufferedInputStream in;
				try {
					// append nowStr to url
					website = new URL(url);
					in = new BufferedInputStream(website.openStream());
					readFromInputStream(in, sList);
				} catch (IOException e) {
					log.error(e.getMessage());
				}

				if (!sList.isEmpty()) {
					String line0 = sList.get(0);

					log.info(line0);

					if (jedis.get(line0) == null) {
						for (String str : sList) {
							Tidal tidal = new Tidal(str);
							if (tidal.isValid()) {

								DB.save(tidal);
								count++;
							}
						}
						jedis.set(line0, "1");
					}
				}

				// ----------

			} // for

			setRedisTrue(keys);
			log.info("All redis keys set to Y");

			log.info("Tried " + urls.size() + " possible URLs. Done " + count + " queries in DB.");
		} // if

		jedis.close();

		Date endProgramTime = Calendar.getInstance().getTime();
		long diffInMillies = Math.abs(startProgramTime.getTime() - endProgramTime.getTime());
		long sec = diffInMillies / 1000;
		long usedMin = sec / 60;
		long usedSec = sec % 60;

		log.info("Total running time: " + usedMin + " minutes " + usedSec + " seconds.");
	}

	// read inputstream, convert to strings, add in the given List
	// the csv file may have a BOM (65279) at the beginning
	private static void readFromInputStream(InputStream inputStream, List<String> sList) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				// skip the first header line
				if (count > 0) {
					sList.add(line);
				}
				count++;
			}
		}
	}

	public static void setRedisTrue(List<String> redisKeys) {
		redisKeys.forEach((k) -> {
			jedis.set(k, "Y");
		});
	}

	// return null if there is no "one-hour-missing" list
	public static List<String> processArchiveUrls() {
		String getMissingBeforeDaysSt = Props.getMissingBeforeDaysSt;
		String getMissingBeforeDaysEd = Props.getMissingBeforeDaysEd;
		String archiveBaseUrlHKO = Props.archiveBaseUrlHKO;
		String archiveBaseUrlMD = Props.archiveBaseUrlMD;
		String fileListBaseUrlHKO = Props.fileListBaseUrlHKO;
		String fileListBaseUrlMD = Props.fileListBaseUrlMD;
		String genTodayMissings = Props.genTodayMissings;
		String th = Props.getMissingTh;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(getMissingBeforeDaysSt));
		String st = sdf.format(cal.getTime());

		cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(getMissingBeforeDaysEd));
		String ed = sdf.format(cal.getTime());

		String checkMissingUrl = Props.apiBaseUrl + "/tide/getMissing?st=" + st + "&ed=" + ed + "&th=" + th;
		System.out.println(checkMissingUrl);

		ArrayList<List<String>> tmpMissings = ReadUrlToArrayList(checkMissingUrl);

		if (tmpMissings == null) {
			System.out.println("No Missings found");
		} else {
			try {
				List<String> archiveUrls = new ArrayList<String>();
				ArrayList<List<String>> missings = addOneHourToMissings(tmpMissings);

				System.out.println("ArrayList<List<String>> missings = " + missings);

				if (missings != null) {
					List<String> uniqueDates = findDistincts(missings, 0);

					List<String> fileListURLsHKO = genDataGovFileVersionList(uniqueDates, fileListBaseUrlHKO);
					List<String> fileListURLsMD = genDataGovFileVersionList(uniqueDates, fileListBaseUrlMD);

					List<String> allFileListHKO = getFileListFromDataGov(fileListURLsHKO);
					List<String> allFileListMD = getFileListFromDataGov(fileListURLsMD);

					List<String> uniquePrefixes = findDistincts(missings, 1); // for both HKO & MD
					System.err.println(uniquePrefixes);

					List<String> resultFileNameListHKO = searchNeededFiles(allFileListHKO, uniquePrefixes);
					List<String> resultFileNameListMD = searchNeededFiles(allFileListMD, uniquePrefixes);

					System.err.println(resultFileNameListHKO);

					List<String> archiveUrlsHKO = genDataGovArchiveURL(resultFileNameListHKO, archiveBaseUrlHKO);
					List<String> archiveUrlsMD = genDataGovArchiveURL(resultFileNameListMD, archiveBaseUrlMD);

					archiveUrls.addAll(archiveUrlsHKO);
					archiveUrls.addAll(archiveUrlsMD);
				}

				if (genTodayMissings.equals(new String("1"))) {
					List<String> archiveUrlsTodayHKO = genDataGovArchiveUrlToday(archiveBaseUrlHKO, "HKO");
					List<String> archiveUrlsTodayMD = genDataGovArchiveUrlToday(archiveBaseUrlMD, "MD");
					archiveUrls.addAll(archiveUrlsTodayHKO);
					archiveUrls.addAll(archiveUrlsTodayMD);
				}

				return archiveUrls;

			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		return null;

	}

	private static List<String> genDataGovArchiveUrlToday(String baseUrl, String key) {
		List<String> urls = new ArrayList<String>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmm");
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int currentMinuteOfDay = ((hour * 60) + minute);

		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);

		for (int i = 0; i < currentMinuteOfDay - 14; i++) {
			String dateHrMin = sdf.format(cal.getTime());

			if (jedis.get(dateHrMin + key) == null || jedis.get(dateHrMin + key).equals("N")) {
				urls.add(baseUrl + dateHrMin);
				jedis.set(dateHrMin + key, "N");
				keys.add(dateHrMin + key);
			}
			cal.add(Calendar.MINUTE, 1);
		}

//		for (int i = -1 * currentMinuteOfDay; i <= -15; i++) {
//			cal.add(Calendar.MINUTE, 1);
//			String dateHrMin = sdf.format(cal.getTime());
//			if (jedis.get(dateHrMin + key) == null || jedis.get(dateHrMin + key).equals(new String("N"))) {
//				urls.add(baseUrl + dateHrMin);
//				jedis.set(dateHrMin + key, "N");
//				keys.add(dateHrMin + key);
//			}
//		}
		return urls;
	}

	private static List<String> genDataGovArchiveURL(List<String> resultFileList, String baseUrl) {
		List<String> urls = new ArrayList<String>();
		Iterator<String> iterate = resultFileList.iterator();
		while (iterate.hasNext()) {
			// access element
			String dateHr = iterate.next();
			urls.add(baseUrl + dateHr);
		}
		return urls;
	}

	private static List<String> searchNeededFiles(List<String> allFileList, List<String> uniquePrefixes) {
		List<String> rs = new ArrayList<String>();
		uniquePrefixes.forEach((p) -> {
			allFileList.forEach((f) -> {
				if (f.contains(p))
					rs.add(f);
			});
		});
		return rs;
	}

	private static List<String> getFileListFromDataGov(List<String> urls) {
		List<String> fileList = new ArrayList<String>();
		Iterator<String> iterate = urls.iterator();
		while (iterate.hasNext()) {
			// access element
			String element = iterate.next();
			try {
				URL url = new URL(element);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				log.info("getFileListFromDataGov: " + element);

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String urlString = "";
				String current;
				while ((current = in.readLine()) != null) {
					urlString += current;
				}

				ObjectMapper objectMapper = new ObjectMapper();
				JsonFactory factory = objectMapper.getFactory();
				JsonParser parser = factory.createParser(urlString);
				JsonNode jn = objectMapper.readTree(parser);
				JsonNode jn1 = jn.get("timestamps");

				String jn1Str = jn1.toString().replaceAll("\\\"", "").replaceAll("\\[", "").replaceAll("\\]", "");

				String str[] = jn1Str.split(",");
				List<String> strList = new ArrayList<>();
				strList = Arrays.asList(str);
				fileList.addAll(strList);

			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
//		System.err.println(fileList);
		return fileList;
	}

	private static List<String> genDataGovFileVersionList(List<String> uniqueDates, String baseUrl) {
		List<String> urls = new ArrayList<String>();
		Iterator<String> iterate = uniqueDates.iterator();
		while (iterate.hasNext()) {
			// access element
			String date = iterate.next();
			String paraToBaseUrl = "&start=" + date + "&end=" + date;
//			System.out.println(baseUrl + paraToBaseUrl);
			urls.add(baseUrl + paraToBaseUrl);
		}
		return urls;
	}

	private static List<String> findDistincts(ArrayList<List<String>> Missings, int x) {
		List<String> uniques = new ArrayList<>();
		Iterator<List<String>> iterate = Missings.iterator();
		while (iterate.hasNext()) {

			// access element
			List<String> element = iterate.next();
			if (!uniques.contains(element.get(x))) {
				uniques.add(element.get(x));
//				System.out.print(element.get(x) + ": ");
//				// access index of each element
//				System.out.println(Missings.indexOf(element));
			}
		}
		return uniques;
	}

	private static ArrayList<List<String>> addOneHourToMissings(ArrayList<List<String>> missList) {
//		ArrayList<List<String>> addOneHourListTmp = (ArrayList<List<String>>) missList.clone();
//		ArrayList<List<String>> addOneHourListTmp = (ArrayList<List<String>>) missList;

		int size = missList.size();

		List<String> allPrefix = new ArrayList<>();
		for (int j = 0; j < size; j++) {
			allPrefix.add(missList.get(j).get(1));
		}

		for (int i = 0; i < size; i++) {
			String time = missList.get(i).get(1);
			String pattern = "yyyyMMdd";
			String pattern2 = "yyyyMMdd-HH";
			DateFormat df = new SimpleDateFormat(pattern, Locale.CHINA);
			DateFormat df2 = new SimpleDateFormat(pattern2, Locale.CHINA);
			Calendar cal = Calendar.getInstance();
			try {
				Date date = df2.parse(time);
				cal.setTime(date);
				cal.add(Calendar.HOUR_OF_DAY, 1);
			} catch (ParseException e) {
				log.error(e.getMessage());
			}

			List<String> tempList = new ArrayList<>();
			tempList.add(df.format(cal.getTime()));
			tempList.add(df2.format(cal.getTime()));
			tempList.add("0");
			if (!allPrefix.contains(df2.format(cal.getTime()))) {
				missList.add(tempList);
			}
		}

		ArrayList<List<String>> addOneHourList = new ArrayList<>();

		for (int k = 0; k < missList.size(); k++) {
			String tmpKey = missList.get(k).get(1) + "_" + missList.get(k).get(2);
			if (jedis.get(tmpKey) == null || jedis.get(tmpKey).equals(new String("N"))) {
				addOneHourList.add(missList.get(k));
				jedis.set(tmpKey, "N");
				keys.add(tmpKey);
			}
		}

		if (addOneHourList.isEmpty()) {
			return null;
		}

		return addOneHourList;
	}

	private static ArrayList<List<String>> ReadUrlToArrayList(String s) {
		try {
			URL url = new URL(s);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			log.info("ReadUrlToArrayList: " + s);

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String urlString = "";
			String current;
			while ((current = in.readLine()) != null) {
				urlString += current;
			}

			if (urlString.length() <= 2)
				return null;

			// Split on this delimiter
			String[] rows = urlString.split("],\\[");
			for (int i = 0; i < rows.length; i++) {
				// Remove any beginning and ending braces and any white spaces
				rows[i] = rows[i].replace("[[", "").replace("]]", "").replace("\"", "").replaceAll(" ", "");
			}

			// Get the number of columns in a row
//		 int numberOfColumns = rows[0].split(",").length;

			// Setup your matrix
//		  String[][] matrix = new String[rows.length][numberOfColumns];
			ArrayList<List<String>> matrix = new ArrayList<>();

			for (int i = 0; i < rows.length; i++) {
				String str[] = rows[i].split(",");
				List<String> matrix2 = new ArrayList<>();
				matrix2 = Arrays.asList(str);
				matrix.add(matrix2);
			}
			System.out.println(matrix);
//			System.out.println(matrix.size());
//		 System.out.println(matrix.get(1).get(0));
//		 System.out.println(matrix.get(1).get(1));
//		 System.out.println(matrix.get(1).get(2));
//		 // Populate your matrix
//		 for (int i = 0; i < rows.length; i++) {
//		     matrix[i] = rows[i].split(",");
//		 }
			// Display your matrix
//		 System.out.println(Arrays.deepToString(matrix));
//		 System.out.println(matrix[0][0]);
//		 System.out.println(matrix[0][1]);
//		 System.out.println(matrix[0][2]);

			// System.out.println(urlString);

			return matrix;

		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;
	}

}
