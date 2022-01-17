package common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {
	public static Timestamp lastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTime().getTime());
	}

	public static String getAllSql(String name) {
		return "select * from wpg." + name;
	}

	public static int getCurrentYear() {
		Calendar calendar = Calendar.getInstance();
		int yr = calendar.get(Calendar.YEAR);
		return yr;
	}

	public static String getTodayMinusTwo() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -2);

		// for debug
		cal.set(Calendar.DAY_OF_MONTH, 12);

//		cal.set(Calendar.HOUR, 0);
//		cal.set(Calendar.MINUTE, 0);
//		cal.set(Calendar.SECOND, 0);
//		cal.set(Calendar.MILLISECOND, 0);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" + " 00:00:00");
		return sdf.format(cal.getTime());

	}

}
