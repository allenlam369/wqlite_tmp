package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.TenZone;

public class UpdateTenZone implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateTenZone me = new UpdateTenZone();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "ten_zone";
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

					TenZone row = new TenZone();

					row.setZoneId(rs.getString("zone_id"));
					row.setZoneName(rs.getString("zone_name"));
					row.setChineseName(rs.getString("chinese_name"));
					row.setZoneOrder(rs.getBigDecimal("zone_order"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));

//					System.err.println(row.getZoneId());

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
