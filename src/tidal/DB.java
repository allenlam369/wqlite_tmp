package tidal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import common_pg.Props;

public class DB {

//	static Connection con = null;
	private static DB INSTANCE;

	static Map<String, Integer> name2IdMap = null;
	static Logger log = LoggerFactory.getLogger(DB.class);

	// only for testing
	public static void main(String[] args) {
		System.out.println("test");
	}

	private DB() {
//		con = ConnectPostgres.getConnection();
		loadMap();
	}

	// Singleton
	public static DB getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DB();
		}
		return INSTANCE;
	}

	public static void save(Tidal t) {
//		if (name2IdMap == null) {
//			loadMap();
//		}

		postToSave(t);
	}

	private static String postToSave(Tidal t) {

		Integer stationId = name2IdMap.get(t.getStationName());

		if (stationId == null) {
			log.error("cannot map station name to id");
			return null;
		}

		t.setStation_id(stationId);

		System.err.println(t.getStationName() + " -> " + stationId);

		try {
//			URL url = new URL("http://localhost:5050/uvi/saveOrUpdate");
			URL url = new URL(Props.apiBaseUrl + "/tide/saveOrUpdate");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			// jackson
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(t);

			// will create a json string from Tidal object, like this:
//			{"id":0,"station_id":1,"stationName":"Quarry Bay","datetime":1634276100000,"height":0.77,"valid":true,"datetimeStr":"2021-10-15 13:35"}
//			System.out.println(json);

			// sending, call api to save/update db
			OutputStream os = con.getOutputStream();
			byte[] input = json.getBytes("utf-8");
			os.write(input, 0, input.length);

			// read Response From Input Stream (will be Tide.toString())
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				log.info("api resp: " + response.toString());
				return response.toString();
			} catch (Exception e) {
				log.error(e.getMessage());
			}

		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return null;

	}

	public static void loadMap() {
		if (name2IdMap == null) {
			name2IdMap = new HashMap<>();

			name2IdMap.put("Quarry Bay", 1);
			name2IdMap.put("Shek Pik", 2);
			name2IdMap.put("Tsim Bei Tsui", 3);
			name2IdMap.put("Tai Miu Wan", 4);
			name2IdMap.put("Tai Po Kau", 5);
			name2IdMap.put("Tai O", 6);
			name2IdMap.put("Kwai Chung", 7);
			name2IdMap.put("Ma Wan", 8);
			name2IdMap.put("Cheung Chau", 9);
			name2IdMap.put("Ko Lau Wan", 10);
			name2IdMap.put("Sha Kiu Tau", 11);
		}

//		StringBuilder sb = new StringBuilder();
//		for (Map.Entry<String, Integer>entry : name2IdMap.entrySet()) {
//			sb.append(entry.getKey()).append(" : ").append(entry.getValue()).append("\n");
//		}
//		System.err.println(sb.toString());
	}

}
