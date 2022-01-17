package tidal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tidal {
	int id;
	int station_id;
	String stationName;
	Date datetime;
	float height;
	boolean valid = true;

	static String pattern = "yyyy-MM-dd HH:mm";
	static SimpleDateFormat sdf = new SimpleDateFormat(pattern);

	// constructor
	// input string likes this: "Tai O,2021-09-23,12:45,2.04"
	public Tidal(String str) {

		String[] ss = str.split(",");

		for (int i = 0; i < ss.length; i++) {
			this.stationName = ss[0];
			String ymd = ss[1];
			String tt = ss[2];

			String tString = ymd + " " + tt;
			try {
				this.datetime = sdf.parse(tString);
			} catch (ParseException e) {
				valid = false;
				System.err.println(e.getMessage());
			}

			try {
				this.height = Float.parseFloat(ss[3]);
			} catch (NumberFormatException e) {
				valid = false;
				System.err.println(e.getMessage());
			}
		}
	}

	public Tidal(String stationName, Date datetime, float height) {
		this.stationName = stationName;
		this.datetime = datetime;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String station) {
		this.stationName = station;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Date getDatetime() {
		return datetime;
	}

	public String getDatetimeStr() {
		return sdf.format(datetime);
	}

	public void setTimestamp(Date datetime) {
		this.datetime = datetime;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public boolean isValid() {
		return valid;
	}

	@Override
	public String toString() {
		return "Tidal [id=" + id + ", station_id=" + station_id + ", stationName=" + stationName + ", datetime="
				+ datetime + ", height=" + height + ", valid=" + valid + "]";
	}

}
