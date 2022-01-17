package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import common.ConnectMssql;
import common.EntityManagerUtil;
import common.Utils;
import model.RiverWaterWqoSum0;
import model.RiverWaterWqoSum0PK;

public class UpdateRiverWaterWqoSum0 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "river_water_wqo_sum0";

	public static void main(String[] args) throws SQLException {
		UpdateRiverWaterWqoSum0 me = new UpdateRiverWaterWqoSum0();
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
		int count = 0;
		if (con != null) {
			int yr = Utils.getCurrentYear();
			sql += " where yr >= " + (yr - 2);
			System.err.println(sql);
			UpdateAll.sList.add(sql);

			count = updateAllFromMssql(con, em, sql);
		}
		return count;
	}

	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					RiverWaterWqoSum0 row = new RiverWaterWqoSum0();
					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));
					row.setRiver(rs.getString("river"));

					RiverWaterWqoSum0PK id = new RiverWaterWqoSum0PK();
					id.setStation(rs.getString("station"));
					id.setYr(rs.getInt("yr"));
					row.setId(id);

					row.setTotal(rs.getInt("total"));
					row.setMinPh(rs.getBigDecimal("min_ph"));
					row.setMaxPh(rs.getBigDecimal("max_ph"));
					row.setNPh(rs.getInt("n_ph"));
					row.setMPh(rs.getInt("m_ph"));
					row.setRatePh(rs.getBigDecimal("rate_ph"));
					row.setNBod5(rs.getInt("n_bod5"));
					row.setMaxBod5(rs.getBigDecimal("max_bod5"));
					row.setMBod5(rs.getInt("m_bod5"));
					row.setRateBod5(rs.getBigDecimal("rate_bod5"));
					row.setMaxCod(rs.getBigDecimal("max_cod"));
					row.setNCod(rs.getInt("n_cod"));
					row.setMCod(rs.getInt("m_cod"));
					row.setRateCod(rs.getBigDecimal("rate_cod"));
					row.setMinDo(rs.getBigDecimal("min_do"));
					row.setNDo(rs.getInt("n_do"));
					row.setMDo(rs.getInt("m_do"));
					row.setRateDo(rs.getBigDecimal("rate_do"));
					row.setMaxAmdSs(rs.getBigDecimal("max_amd_ss"));
					row.setNSs(rs.getInt("n_ss"));
					row.setAmdSs(rs.getBigDecimal("amd_ss"));
					row.setRateSsAmd(rs.getInt("rate_ss_amd"));
					row.setMaxNh4(rs.getBigDecimal("max_nh4"));
					row.setNNh4(rs.getInt("n_nh4"));
					row.setMNh4(rs.getInt("m_nh4"));
					row.setRateNh4(rs.getBigDecimal("rate_nh4"));
					row.setMaxAamNh3(rs.getBigDecimal("max_aam_nh3"));
					row.setNh3Aam(rs.getBigDecimal("nh3_aam"));
					row.setRateNh3Aam(rs.getInt("rate_nh3_aam"));
					row.setMax5mdEc(rs.getBigDecimal("max_5md_ec"));
					row.setNEc5md(rs.getInt("n_ec_5md"));
					row.setMEc5md(rs.getInt("m_ec_5md"));
					row.setRateEc5md(rs.getBigDecimal("rate_ec_5md"));
					row.setMax5gmEc(rs.getBigDecimal("max_5gm_ec"));
					row.setNEc5gm(rs.getInt("n_ec_5gm"));
					row.setMEc5gm(rs.getInt("m_ec_5gm"));
					row.setRateEc5gm(rs.getBigDecimal("rate_ec_5gm"));
					row.setMaxAgmEc(rs.getBigDecimal("max_agm_ec"));
					row.setEcAgm(rs.getDouble("ec_agm"));
					row.setRateEcAgm(rs.getInt("ec_agm"));
					row.setRate4wqo(rs.getBigDecimal("rate_4wqo"));
					row.setRate5wqo(rs.getBigDecimal("rate_5wqo"));

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
