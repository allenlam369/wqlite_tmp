package dbUpdate;

import java.sql.Timestamp;
import java.util.Calendar;

public class Utils {
	public static Timestamp previous2Years(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		cal.add(Calendar.YEAR, -2);
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

}
