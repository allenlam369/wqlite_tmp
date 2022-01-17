package uvi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import common_pg.Props;

public class DB {

//	static Connection con = null;
//	private static DB INSTANCE;
//	static Logger log = Logger.getLogger(DB.class.getName());
	static Logger log = LoggerFactory.getLogger(DB.class);

	// only for testing
	public static void main(String[] args) {

	}

	private DB() {
//		con = ConnectPostgres.getConnection();
	}

//	// Singleton
//	public static DB getInstance() {
//		if (INSTANCE == null) {
//			INSTANCE = new DB();
//		}
//		return INSTANCE;
//	}

	public static void save(Uvi u) {
		postToSave(u);
	}

	private static String postToSave(Uvi u) {
		try {
//			URL url = new URL("http://localhost:5050/uvi/saveOrUpdate");

			URL url = new URL(Props.apiBaseUrl + "/uvi/saveOrUpdate");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(u);

			// {"datetime" : "2021-09-0T18:45:00+08", "uvi" : 1.1}

			// sending
			OutputStream os = con.getOutputStream();
			byte[] input = json.getBytes("utf-8");
			os.write(input, 0, input.length);

			// read Response From Input Stream

			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				StringBuilder response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
				log.info(response.toString());
				return response.toString();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
