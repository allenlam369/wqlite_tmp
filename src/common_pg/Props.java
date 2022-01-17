package common_pg;

import common.PropertyLoader;

public class Props {
	static String url = PropertyLoader.getInstance().getProperty("dockerPostgresUrl");
	static String user = PropertyLoader.getInstance().getProperty("dockerPostgresUser");
	static String pass = PropertyLoader.getInstance().getProperty("dockerPostgresPassword");
	public static String apiBaseUrl = PropertyLoader.getInstance().getProperty("apiBaseUrl");
	public static String hkoUviFile = PropertyLoader.getInstance().getProperty("hkoUviFile");
	public static String hkoTideFile = PropertyLoader.getInstance().getProperty("hkoTideFile");
	public static String mdTideFile = PropertyLoader.getInstance().getProperty("mdTideFile");
	public static String tideFileList = PropertyLoader.getInstance().getProperty("tideFileList");

	public static String fileListBaseUrlHKO = PropertyLoader.getInstance().getProperty("fileListBaseUrlHKO");
	public static String fileListBaseUrlMD = PropertyLoader.getInstance().getProperty("fileListBaseUrlMD");
	public static String archiveBaseUrlHKO = PropertyLoader.getInstance().getProperty("archiveBaseUrlHKO");
	public static String archiveBaseUrlMD = PropertyLoader.getInstance().getProperty("archiveBaseUrlMD");
	public static String getMissingBeforeDaysSt = PropertyLoader.getInstance().getProperty("getMissingBeforeDaysSt");
	public static String getMissingBeforeDaysEd = PropertyLoader.getInstance().getProperty("getMissingBeforeDaysEd");
	public static String getMissingTh = PropertyLoader.getInstance().getProperty("getMissingTh");
	public static String genTodayMissings = PropertyLoader.getInstance().getProperty("genTodayMissings");
	public static String redisHost = PropertyLoader.getInstance().getProperty("redisHost");
	public static String redisPort = PropertyLoader.getInstance().getProperty("redisPort");
}
