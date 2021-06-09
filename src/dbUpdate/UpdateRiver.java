package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.River;

public class UpdateRiver implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateRiver me = new UpdateRiver();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "river";
		getAllFromMssql(con, em, dbName);

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

					River row = new River();
					row.setRId(rs.getString("r_id"));
					row.setZoneId(rs.getString("zone_id"));
					row.setRiverName(rs.getString("river_name"));
					row.setChineseName(rs.getString("chinese_name"));
					row.setRiverId(rs.getBigDecimal("river_id"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));

//					System.err.println(row.getRId());

					em.merge(row);

					if (i % 1000 == 0) {
						em.flush();
						em.clear();
					}
				} // while

//				em.getTransaction().commit();

//				System.err.println("row count: " + i);
				return i;
			}

			else {
				System.err.println("con is null");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
