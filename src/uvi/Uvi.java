package uvi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uvi {
	static String pattern = "yyyyMMddHHmm"; // for reading input data
	static String pattern2 = "yyyy-MM-dd HH:mm"; // for db data matching
	static String pattern3 = "yyyy-MM-dd HH:mm:ss.SSSX"; // for dbapi
	static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	static SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);
	static SimpleDateFormat sdf3 = new SimpleDateFormat(pattern3);

	int id;
	Date datetime;
	double uvi;

	public Uvi(Date datetime, double uvi) {
//		sdf3.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));
		this.datetime = datetime;
		this.uvi = uvi;
	}

//	Date time,past 15-minute mean UV Index
//	202109071445,6
	public Uvi(String str) {
		String[] ss = str.split(",");
		try {
			this.datetime = sdf.parse(ss[0]);
			this.uvi = Float.parseFloat(ss[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public double getUvi() {
		return uvi;
	}

	public String getDatetimeStr() {
		return sdf3.format(datetime);
	}

	@Override
	public String toString() {
		return "Uvi [datetime=" + sdf3.format(datetime) + ", uvi=" + uvi + "]";
	}

}
