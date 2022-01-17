package tidal;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common_pg.Props;

public class Download {
	static String pattern = "yyyyMMdd-HH"; // for attaching to url
	static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	
	// filename is always the same
//	static String HKO = "https://data.weather.gov.hk/weatherAPI/hko_data/tide/ALL_en.csv";
	// Marine Dept
//	static String MD = "https://tide1.hydro.gov.hk/hotide/OpenData/All_en.csv";
// hkoTideFile=https://api.data.gov.hk/v1/historical-archive/get-file?url=https%3A%2F%2Fdata.weather.gov.hk%2FweatherAPI%2Fhko_data%2Ftide%2FALL_en.csv&time=yyyyMMdd-HHmm

	static DB db = DB.getInstance();

	static Map<String, Integer> stationMap1 = null;

	// will be called by mvn exec:exec@id4
	public static void main(String[] args) {
		downloadTidal();
	}

	private static void downloadTidal() {
	
		List<String> sList = new ArrayList<>();

		URL website;
		BufferedInputStream in;
		try {
			// append nowStr to url
//			website = new URL(Props.hkoTideFile + nowStr);
			website = new URL(Props.hkoTideFile);
			in = new BufferedInputStream(website.openStream());
			readFromInputStream(in, sList);

			website = new URL(Props.mdTideFile);
			in = new BufferedInputStream(website.openStream());
			readFromInputStream(in, sList);

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String str : sList) {
			Tidal tidal = new Tidal(str);
			if (tidal.isValid()) {
				DB.save(tidal);
			}
		}

//		db.close();
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

}
