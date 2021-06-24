package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.RwWqiAvg;
import model.RwWqiAvgPK;

public class UpdateRwWqiAvg implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "rw_wqi_avg";

	public static void main(String[] args) throws SQLException {
		UpdateRwWqiAvg me = new UpdateRwWqiAvg();
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

					RwWqiAvg row = new RwWqiAvg();

					RwWqiAvgPK id = new RwWqiAvgPK();
					id.setSiteId(rs.getLong("site_id"));
					id.setYr(rs.getInt("yr"));
					row.setId(id);

					row.setTotal(rs.getInt("total"));
					row.setBod5PtAvg(rs.getBigDecimal("bod5_pt_avg"));
					row.setNh4PtAvg(rs.getBigDecimal("nh4_pt_avg"));
					row.setDosPtAvg(rs.getBigDecimal("dos_pt_avg"));
					row.setWqiPtAvg(rs.getBigDecimal("wqi_pt_avg"));
					row.setWqiGradeAvg(rs.getString("wqi_grade_avg"));

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
