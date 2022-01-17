package uvi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import common_pg.Props;

public class Download {

	// filename is always the same
	// static String HKO =
	// "https://data.weather.gov.hk/weatherAPI/hko_data/regional-weather/latest_15min_uvindex.csv";

	// static DB db = DB.getInstance();

	// will be called by mvn exec:exec@id5
	public static void main(String[] args) {
		downloadUvi();
	}

	private static void downloadUvi() {
		List<String> sList = new ArrayList<>();

		URL website;
		BufferedInputStream in;
		try {
			website = new URL(Props.hkoUviFile);
			in = new BufferedInputStream(website.openStream());
			readFromInputStream(in, sList);

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String str : sList) {
			Uvi u = new Uvi(str);
			DB.save(u);
		}
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
