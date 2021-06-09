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

		String dbName = "rw_wqi_avg";
		int count = getAllFromMssql(con, em, dbName);
		System.err.println("count = " + count);

		em.getTransaction().commit();
		em.close();
		con.close();
	}

	public int getAllFromMssql(Connection con, EntityManager em, String dbName) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				String sql = "select * from wpg." + dbName;
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
}