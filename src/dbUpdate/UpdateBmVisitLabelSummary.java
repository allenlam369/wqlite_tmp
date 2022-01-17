package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import common.ConnectMssql;
import common.EntityManagerUtil;
import common.Utils;
import model.BmVisitLabelSummary;

public class UpdateBmVisitLabelSummary implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "bm_visit_label_summary";

	public static void main(String[] args) throws SQLException {
		UpdateBmVisitLabelSummary me = new UpdateBmVisitLabelSummary();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		// delete all rows in postgres table
		truncatePostgresTable();

		String sql = Utils.getAllSql(dbName);
		int count = incrementalUpdateFromMssql(con, em, sql);
		System.err.println("count = " + count);

		em.getTransaction().commit();
		em.close();
		con.close();
	}

	public int incrementalUpdateFromMssql(Connection con, EntityManager em, String sql) {
		Timestamp ts2 = Utils.lastMonth();
		sql += " where mdate >= '" + ts2 + "'";
		System.err.println(sql);
		UpdateAll.sList.add(sql);
		int count = updateAllFromMssql(con, em, sql);
		return count;
	}
	
//	public int incrementalUpdateFromMssql(Connection con, EntityManager em, String sql) {
//		int count = 0;
//		try {
//			Timestamp ts2 = null;
//			if (con != null) {
//				Statement stmt = con.createStatement();
//				// find the latest date in this table of mssql
//				String sql1 = "SELECT top 1 mdate FROM WPG.bm_visit_label_summary order by mdate DESC";
//				
//				ResultSet rs = stmt.executeQuery(sql1);
//
//				// Iterate through the data in the result set and display it.
//				if (rs.next()) {
//					Timestamp ts = rs.getTimestamp("mdate");
//					ts2 = Utils.lastMonth(ts);
//				}
//
//				// query for rows 2 years older the latest date
//				sql += " where mdate >= '" + ts2 + "'";
//				System.err.println(sql);
//				
//				UpdateAll.sList.add(sql);
//
//				count = updateAllFromMssql(con, em, sql);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return count;
//	}

	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					BmVisitLabelSummary row = new BmVisitLabelSummary();

					row.setDistrictName(rs.getString("district_name"));
					row.setBeachName(rs.getString("beach_name"));
					row.setBeachGroup(rs.getString("beach_group"));
					row.setClosed(rs.getString("closed"));
					row.setDistrictOrder(rs.getString("district_order"));
					row.setListOrder(rs.getString("list_order"));
					row.setBmvisitId(rs.getString("bmvisit_id"));
					row.setSiteId(rs.getBigDecimal("site_id"));
					row.setMdate(rs.getTimestamp("mdate"));
					row.setStime(rs.getBigDecimal("stime"));
					row.setSampleNo(rs.getBigDecimal("sample_no"));
					row.setBeachCode(rs.getString("beach_code"));
					row.setSampleDate(rs.getTimestamp("sample_date"));
					row.setSampleTime(rs.getString("sample_time"));
					row.setTemper(rs.getBigDecimal("temper"));
					row.setDo_(rs.getBigDecimal("do"));
					row.setDos(rs.getBigDecimal("dos"));
					row.setSal(rs.getBigDecimal("sal"));
					row.setSalR(rs.getBigDecimal("sal_r"));
					row.setSalM(rs.getBigDecimal("sal_m"));
					row.setSalL(rs.getBigDecimal("sal_l"));
					row.setSalO(rs.getBigDecimal("sal_o"));
					row.setPh(rs.getBigDecimal("ph"));
					row.setTurb(rs.getBigDecimal("turb"));
					row.setWeatherValue(rs.getBigDecimal("weather_value"));
					row.setWindValue(rs.getBigDecimal("wind_value"));
					row.setClimateValue(rs.getBigDecimal("climate_value"));
					row.setSeaClarityValue(rs.getBigDecimal("sea_clarity_value"));
					row.setSeaConditionValue(rs.getBigDecimal("sea_condition_value"));
					row.setWindDirection(rs.getString("wind_direction"));
					row.setBatherValue(rs.getBigDecimal("bather_value"));
					row.setTideValue(rs.getBigDecimal("tide_value"));
					row.setTideRatio(rs.getBigDecimal("tide_ratio"));
					row.setTideHeight(rs.getBigDecimal("tide_height"));
					row.setAbsTideHeight(rs.getBigDecimal("abs_tide_height"));
					row.setEcR(rs.getBigDecimal("ec_r"));
					row.setEcM(rs.getBigDecimal("ec_m"));
					row.setEcL(rs.getBigDecimal("ec_l"));
					row.setEcO(rs.getBigDecimal("ec_o"));
					row.setEcS1(rs.getBigDecimal("ec_s1"));
					row.setEcS2(rs.getBigDecimal("ec_s2"));
					row.setEcS3(rs.getBigDecimal("ec_s3"));
					row.setEcS4(rs.getBigDecimal("ec_s4"));
					row.setEcS5(rs.getBigDecimal("ec_s5"));
					row.setSalS1(rs.getBigDecimal("sal_s1"));
					row.setSalS2(rs.getBigDecimal("sal_s2"));
					row.setSalS3(rs.getBigDecimal("sal_s3"));
					row.setSalS4(rs.getBigDecimal("sal_s4"));
					row.setSalS5(rs.getBigDecimal("sal_s5"));
					row.setSalF12(rs.getBigDecimal("sal_f1_2"));
					row.setSalF22(rs.getBigDecimal("sal_f2_2"));
					row.setSalF32(rs.getBigDecimal("sal_f3_2"));
					row.setSalF42(rs.getBigDecimal("sal_f4_2"));
					row.setSalF52(rs.getBigDecimal("sal_f5_2"));
					row.setFlowS1(rs.getString("flow_s1"));
					row.setFlowS2(rs.getString("flow_s2"));
					row.setFlowS3(rs.getString("flow_s3"));
					row.setFlowS4(rs.getString("flow_s4"));
					row.setFlowS5(rs.getString("flow_s5"));
					row.setFlowF1(rs.getString("flow_f1"));
					row.setFlowF2(rs.getString("flow_f2"));
					row.setFlowF3(rs.getString("flow_f3"));
					row.setFlowF4(rs.getString("flow_f4"));
					row.setFlowF5(rs.getString("flow_f5"));
					row.setEcF1(rs.getBigDecimal("ec_f1"));
					row.setEcF2(rs.getBigDecimal("ec_f2"));
					row.setEcF3(rs.getBigDecimal("ec_f3"));
					row.setEcF4(rs.getBigDecimal("ec_f4"));
					row.setEcF5(rs.getBigDecimal("ec_f5"));
					row.setFcR(rs.getBigDecimal("fc_r"));
					row.setFcM(rs.getBigDecimal("fc_m"));
					row.setFcL(rs.getBigDecimal("fc_l"));
					row.setFcO(rs.getBigDecimal("fc_o"));
					row.setFcS1(rs.getBigDecimal("fc_s1"));
					row.setFcS2(rs.getBigDecimal("fc_s2"));
					row.setFcS3(rs.getBigDecimal("fc_s3"));
					row.setFcS4(rs.getBigDecimal("fc_s4"));
					row.setFcS5(rs.getBigDecimal("fc_s5"));
					row.setFcF1(rs.getBigDecimal("fc_f1"));
					row.setFcF2(rs.getBigDecimal("fc_f2"));
					row.setFcF3(rs.getBigDecimal("fc_f3"));
					row.setFcF4(rs.getBigDecimal("fc_f4"));
					row.setFcF5(rs.getBigDecimal("fc_f5"));
					row.setGMean(rs.getBigDecimal("g_mean"));
					row.setRGMean(rs.getBigDecimal("r_g_mean"));
					row.setLogGMean(rs.getBigDecimal("log_g_mean"));
					row.setAdjLogGm(rs.getBigDecimal("adj_log_gm"));
					row.setMthGMean(rs.getBigDecimal("mth_g_mean"));
					row.setWkGMean(rs.getBigDecimal("wk_g_mean"));
					row.setGMeanFc(rs.getBigDecimal("g_mean_fc"));
					row.setRGMeanFc(rs.getBigDecimal("r_g_mean_fc"));
					row.setLogGMeanFc(rs.getBigDecimal("log_g_mean_fc"));
					row.setAdjLogGmFc(rs.getBigDecimal("adj_log_gm_fc"));
					row.setMthGMeanFc(rs.getBigDecimal("mth_g_mean_fc"));
					row.setWkGMeanFc(rs.getBigDecimal("wk_g_mean_fc"));
					row.setMoveAvg(rs.getBigDecimal("move_avg"));
					row.setMoveAvgFc(rs.getBigDecimal("move_avg_fc"));
					row.setGrade(rs.getBigDecimal("grade"));
					row.setGradeChange(rs.getBigDecimal("grade_change"));
					row.setRemarks(rs.getString("remarks"));
					row.setDayappend(rs.getTimestamp("dayappend"));
					row.setDayedit(rs.getTimestamp("dayedit"));
					row.setDayupload(rs.getTimestamp("dayupload"));
					row.setRainStationCode(rs.getString("rain_station_code"));
					row.setSdatetime(rs.getTimestamp("sdatetime"));
					row.setRainfall(rs.getBigDecimal("rainfall"));
					row.setRainfallMax3hr(rs.getBigDecimal("rainfall_max_3hr"));
					row.setRainfallMaxTime(rs.getTimestamp("rainfall_max_time"));
					row.setRainfallLast12hr(rs.getBigDecimal("rainfall_last_12hr"));
					row.setRainfallLast24hr(rs.getBigDecimal("rainfall_last_24hr"));
					row.setRainfallLast72hr(rs.getBigDecimal("rainfall_last_72hr"));
					row.setRiskRainMax3hr(rs.getString("risk_rain_max_3hr"));
					row.setRiskRainLast12hr(rs.getString("risk_rain_last_12hr"));
					row.setRiskRainLast24hr(rs.getString("risk_rain_last_24hr"));
					row.setRiskRainLast72hr(rs.getString("risk_rain_last_72hr"));
					row.setWeather(rs.getString("weather"));
					row.setWind(rs.getString("wind"));
					row.setClimate(rs.getString("climate"));
					row.setSeaClarity(rs.getString("sea_clarity"));
					row.setSeaCondition(rs.getString("sea_condition"));
					row.setBather(rs.getString("bather"));
					row.setTide(rs.getString("tide"));
					row.setFlowLabelS1(rs.getString("flow_label_s1"));
					row.setFlowLabelS2(rs.getString("flow_label_s2"));
					row.setFlowLabelS3(rs.getString("flow_label_s3"));
					row.setFlowLabelS4(rs.getString("flow_label_s4"));
					row.setFlowLabelS5(rs.getString("flow_label_s5"));
					row.setFlowLabelF1(rs.getString("flow_label_f1"));
					row.setFlowLabelF2(rs.getString("flow_label_f2"));
					row.setFlowLabelF3(rs.getString("flow_label_f3"));
					row.setFlowLabelF4(rs.getString("flow_label_f4"));
					row.setFlowLabelF5(rs.getString("flow_label_f5"));
					row.setTideStationCode(rs.getString("tide_station_code"));
					row.setMrefuseCleanlinesLevel(rs.getBigDecimal("mrefuse_cleanlines_level"));

					em.merge(row);

					if (i % 1000 == 0) {
						em.flush();
						em.clear();
					}
				} // while

				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// Works only if this table is not referenced by other tables
//	  Detail: Table "bm_visit_label_summary" references "bm_beach".
//	  Hint: Truncate table "bm_visit_label_summary" at the same time, or use TRUNCATE ... CASCADE.
	private void truncatePostgresTable() {
		String sql = "TRUNCATE TABLE " + dbName;
		System.out.println(sql);
		em.createNativeQuery(sql).executeUpdate();
	}
}
