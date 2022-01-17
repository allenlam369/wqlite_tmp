package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import common_pg.Props;
import tidal.Tidal;

public class TestDownload {

	public static void main(String[] args) {
		String url = "https://api.data.gov.hk/v1/historical-archive/get-file?url=https%3A%2F%2Ftide1.hydro.gov.hk%2Fhotide%2FOpenData%2FAll_en.csv&time=20220113-0850";

		downloadTidal(url);

	}

	private static boolean downloadTidal(String urlStr) {
		List<String> sList = new ArrayList<>();
		URL website;
		BufferedInputStream in;
		try {
			// append nowStr to url
			website = new URL(urlStr);
			in = new BufferedInputStream(website.openStream());
			readFromInputStream(in, sList);

			// mdTideFile=https://tide1.hydro.gov.hk/hotide/OpenData/All_en.csv
//			website = new URL(Props.mdTideFile);
//			in = new BufferedInputStream(website.openStream());
//			readFromInputStream(in, sList);

		} catch (IOException e) {
			System.err.println(e.getMessage());
			return false;
		}

		for (String str : sList) {
			Tidal tidal = new Tidal(str);
			if (tidal.isValid()) {
				System.out.println(str);
			}
		}
		return true;
	}

	// read inputstream, convert to strings, add in the given List
	// the csv file may have a BOM (65279) at the beginning
	private static void readFromInputStream(InputStream inputStream, List<String> sList) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			int count = 0;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				
//				System.out.println("> " + line);
				// skip the first header line
				if (count > 0) {
					sList.add(line);
				}
				count++;
			}
		}
	}
}
