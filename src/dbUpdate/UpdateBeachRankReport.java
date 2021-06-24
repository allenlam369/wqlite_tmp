package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.BmBeachEcAgmRankReport;
import model.BmBeachEcAgmRankReportPK;

public class UpdateBeachRankReport implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "BmBeachEcAgmRankReport";

	public static void main(String[] args) throws SQLException {
		UpdateBeachRankReport me = new UpdateBeachRankReport();
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
		// lastUpdateDate found in postgres table
		Timestamp ts = getLastUpdateDateFromPostgres(sql);
		System.out.println("Timestamp=" + ts);

		// postgres table is empty
		if (ts == null) {
			updateAllFromMssql(con, em, dbName);
		}

		// there are existing rows in postgres
		else {
			// get previous day
			ts = previousDay(ts);
			System.out.println("Previous day=" + ts);

//			getRowsFromMssql(2010);
		}

		em.getTransaction().commit();
		em.close();
		con.close();

	}

	public int incrementalUpdateFromMssql(Connection con, EntityManager em, String sql) {
		return updateAllFromMssql(con, em, sql);
	}

	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					BmBeachEcAgmRankReportPK pk = new BmBeachEcAgmRankReportPK();
					pk.setBeachCode(rs.getString("beach_code"));
					pk.setYear(rs.getInt("year"));

					BmBeachEcAgmRankReport report = new BmBeachEcAgmRankReport();
					report.setId(pk);
					report.setDistrictName(rs.getString("district_name"));
					report.setDistrictNameC(rs.getString("district_name_c"));
					report.setHotlineDistrict(rs.getString("hotline_district"));
					report.setHotlineDistrictC(rs.getString("hotline_district_c"));
					report.setBeachName(rs.getString("beach_name"));
					report.setChineseName(rs.getString("chinese_name"));
					report.setScName(rs.getString("sc_name"));
					report.setBeachGroup(rs.getString("beach_group"));
					report.setDistrictOrder(rs.getString("district_order"));
					report.setAnnualLogGMean(rs.getBigDecimal("annual_log_g_mean"));
					report.setAnnualGMean(rs.getBigDecimal("annual_g_mean"));
					report.setSampleCount(rs.getInt("sample_count"));
					report.setRank(rs.getBigDecimal("rank"));
					report.setListOrder2(rs.getString("list_order_2"));

//					System.err.println(pk);

					em.merge(report);

					if (i % 1000 == 0) {
						em.flush();
						em.clear();
					}
				} // while

//				em.getTransaction().commit();

//				System.err.println("row count: " + i);

				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static Timestamp previousDay(Timestamp ts) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return new Timestamp(cal.getTime().getTime());
	}

	private static Timestamp getLastUpdateDateFromPostgres(String dbName) {
		Query q = em.createQuery("from " + dbName + " order by year_ desc");
		q.setMaxResults(10);
		@SuppressWarnings("unchecked")
		List<BmBeachEcAgmRankReport> list = q.getResultList();
		if (!list.isEmpty()) {

			BmBeachEcAgmRankReportPK pk = list.get(0).getId();
			int year = pk.getYear();
			return getTimestamp(year);
		} else {
			return null;
		}
	}

	// assume day 31 of Dec
	private static Timestamp getTimestamp(int year) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 31); // day of month is 1-based
		cal.set(Calendar.MONTH, 11); // month is 0-based
		cal.set(Calendar.YEAR, year);
		Timestamp tstamp = new Timestamp(cal.getTimeInMillis());
		return tstamp;
	}

	private static void getRowsFromMssql(int yr) {
		try {
			if (con != null) {
				Statement stmt = con.createStatement();

				String SQL = "SELECT * FROM WPG.bm_beach_ec_agm_rank_report where year >= " + yr;
				ResultSet rs = stmt.executeQuery(SQL);

				int count = 0;
				// Iterate through the data in the result set and process it.
				while (rs.next()) {
					int year = rs.getInt("year");
					System.out.println(year);

					// is this id existing in local postgres table?
//					BmBeachEcAgmRankReport bb = em.find(BmBeachEcAgmRankReport.class, id);
//					// if not existing, create a new one
//					if (bb == null) {
//						bb = new BmBeachEcAgmRankReport();
//						bb.setDistrictName(rs.getString("district_name"));
//						bb.setDistrictNameC(rs.getString("district_name_c"));
//						bb.setHotlineDistrict(rs.getString("hotline_district"));
//						bb.setHotlineDistrictC(rs.getString("hotline_district_c"));
//						bb.setBeachName(rs.getString("beach_name"));
//						bb.setChineseName(rs.getString("chinese_name"));
//						bb.setScName(rs.getString("sc_name"));
//						bb.setBeachGroup(rs.getString("beach_group"));
//						bb.setDistrictOrder(rs.getString("district_order"));
//						bb.setAnnualLogGMean(rs.getBigDecimal("annual_log_g_mean"));
//						bb.setAnnualGMean(rs.getBigDecimal("annual_g_mean"));
//						bb.setSampleCount(rs.getInt("sample_count"));
//						bb.setRank(rs.getBigDecimal("rank_"));
//						bb.setListOrder2(rs.getString("list_order_2"));
//
//						BmBeachEcAgmRankReportPK pk = new BmBeachEcAgmRankReportPK();
//						pk.setBeachCode(rs.getString("beach_code"));
//						pk.setYear(rs.getInt(rs.getInt("year_")));
//						bb.setId(pk);
//
//						System.out.println(bb);

//						em.persist(br);
//						em.getTransaction().commit();
//
					count++;
//					}
					// skip if the id is existing
				} // while

				System.out.println(count + " rows fetched");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
