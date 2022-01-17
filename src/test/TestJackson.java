package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {

	public static void main(String[] args) throws IOException {

		String[] arr = process();
		for (String s : arr) {
			System.err.println(s);
		}
	}

	private static String[] process() throws MalformedURLException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		// a data string obtained from gov api:
		// https://api.data.gov.hk/v1/historical-archive/list-file-versions?url=https%3A%2F%2Fdata.weather.gov.hk%2FweatherAPI%2Fhko_data%2Ftide%2FALL_en.csv&start=20211013&end=20211013
		
		String jsonSample = "{\"x\":1, \"y\":2, \"timestamps\":[\"20211013-0000\", \"20211013-0005\"],\"data-dictionary-dates\": [], \"schema-dates\": []}";

		String url = "https://api.data.gov.hk/v1/historical-archive/list-file-versions?url=https%3A%2F%2Fdata.weather.gov.hk%2FweatherAPI%2Fhko_data%2Ftide%2FALL_en.csv&start=20211013&end=20211013";
		String jsonContent = getStrFromUrl(url);

//		System.err.println(jsonContent);

		JsonFactory factory = objectMapper.getFactory();
		JsonParser parser = factory.createParser(jsonContent);
		JsonNode jn = objectMapper.readTree(parser);

		JsonNode jn1 = jn.get("timestamps");

//		System.err.println(jn1);

		String str = jn1.toString().replaceAll("\\\"", "").replaceAll("\\[", "").replaceAll("\\]", "");
		String[] ss = str.split(",");

		return ss;
	}

	private static String getStrFromUrl(String aUrl) throws MalformedURLException, IOException {
		String urlData = "";
		URL urlObj = new URL(aUrl);
		URLConnection conn = urlObj.openConnection();
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
			urlData = reader.lines().collect(Collectors.joining("\n"));
		}
		return urlData;
	}
}
