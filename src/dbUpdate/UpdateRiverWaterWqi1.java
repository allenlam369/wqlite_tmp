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
import model.RiverWaterWqi1;
import model.RiverWaterWqi1PK;

public class UpdateRiverWaterWqi1 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "river_water_wqi1";

	public static void main(String[] args) throws SQLException {
		UpdateRiverWater1 me = new UpdateRiverWater1();
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

	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					RiverWaterWqi1 row = new RiverWaterWqi1();

					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));
					row.setRiver(rs.getString("river"));

					RiverWaterWqi1PK id = new RiverWaterWqi1PK();
					id.setStation(rs.getString("station"));
					id.setMdate(rs.getDate("mdate"));
					row.setId(id);
					row.setStime(rs.getBigDecimal("stime"));
					row.setSampleNo(rs.getBigDecimal("sample_no"));
					row.setLBod5(rs.getString("l_bod5"));
					row.setBod5(rs.getBigDecimal("bod5"));
					row.setLNh4(rs.getString("l_nh4"));
					row.setNh4(rs.getBigDecimal("nh4"));
					row.setLDos(rs.getString("l_dos"));
					row.setDos(rs.getBigDecimal("dos"));
					row.setBod5Pt(rs.getBigDecimal("bod5_pt"));
					row.setNh4Pt(rs.getBigDecimal("nh4_pt"));
					row.setDosPt(rs.getBigDecimal("dos_pt"));
					row.setWqiGrade(rs.getString("wqi_grade"));
					row.setViewNo(rs.getBigDecimal("view_no"));

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
	public void truncatePostgresTable() {
		String sql = "TRUNCATE TABLE " + dbName;
		System.out.println(sql);
		em.createNativeQuery(sql).executeUpdate();
	}
}
