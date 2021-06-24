package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.BmBeachEcAgmRankReport;
import model.BmBeachEcAgmRankReportPK;

public class UpdateBeachRankReport implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "bm_beach_ec_agm_rank_report";

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
		int count = updateAllFromMssql(con, em, sql);
		System.err.println("count = " + count);

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

					em.merge(report);

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
