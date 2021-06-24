
package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import model.MarineWaterWqoRaw1;
import model.MarineWaterWqoRaw1PK;

public class UpdateMarineWaterWqoRaw1 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "marine_water_wqo_raw1";

	public static void main(String[] args) throws SQLException {
		UpdateMarineWaterWqoRaw1 me = new UpdateMarineWaterWqoRaw1();
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
		int count = 0;
		try {
			Timestamp ts2 = null;
			if (con != null) {
				Statement stmt = con.createStatement();
				String sql1 = "SELECT top 1 mdate FROM [WPG].[MARINE_WATER_WQO_RAW1] order by mdate DESC";
				ResultSet rs = stmt.executeQuery(sql1);

				// Iterate through the data in the result set and display it.
				if (rs.next()) {
					Timestamp ts = rs.getTimestamp("mdate");
					ts2 = Utils.previous2Years(ts);
				}

				sql += " where mdate >= '" + ts2 + "'";
				System.err.println(sql);

				count = updateAllFromMssql(con, em, sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();

				if (sql.contains("where")) {
					sql += " and station is not null";
				} else {
					sql += " where station is not null";
				}

				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					MarineWaterWqoRaw1 row = new MarineWaterWqoRaw1();
					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));

					MarineWaterWqoRaw1PK id = new MarineWaterWqoRaw1PK();
					id.setStation(rs.getString("station"));
					id.setMdate(rs.getDate("mdate"));
					row.setId(id);

					row.setStime(rs.getBigDecimal("stime"));
					row.setSampleNo(rs.getBigDecimal("sample_no"));

					row.setDos(rs.getBigDecimal("dos"));
					row.setDom(rs.getBigDecimal("dom"));
					row.setDob(rs.getBigDecimal("dob"));
					row.setDoc(rs.getBigDecimal("doc"));
					row.setDoa(rs.getBigDecimal("doa"));
					row.setTin(rs.getBigDecimal("tin"));
					row.setNh3(rs.getBigDecimal("nh3"));
					row.setEcoli(rs.getDouble("ecoli"));
					row.setMinDos(rs.getBigDecimal("min_dos"));
					row.setMinDosPc(rs.getBigDecimal("min_dos_pc"));
					row.setMinDom(rs.getBigDecimal("min_dom"));
					row.setMinDomPc(rs.getBigDecimal("min_dom_pc"));
					row.setMinDob(rs.getBigDecimal("min_dob"));
					row.setMinDobPc(rs.getBigDecimal("min_dob_pc"));
					row.setMinDoc(rs.getBigDecimal("min_doc"));
					row.setMinDocPc(rs.getBigDecimal("min_doc_pc"));
					row.setMinDoa(rs.getBigDecimal("min_doa"));
					row.setMinDoaPc(rs.getBigDecimal("min_doa_pc"));
					row.setMaxTinAam(rs.getBigDecimal("max_tin_aam"));
					row.setMaxNh3Aam(rs.getBigDecimal("max_nh3_aam"));
					row.setMaxEcoliAgm(rs.getBigDecimal("max_ecoli_agm"));
					row.setMeetDos(rs.getString("meet_dos"));
					row.setMeetDom(rs.getString("meet_dom"));
					row.setMeetDob(rs.getString("meet_dob"));
					row.setMeetDoc(rs.getString("meet_doc"));
					row.setMeetDoa(rs.getString("meet_doa"));

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
