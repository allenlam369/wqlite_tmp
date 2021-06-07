package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.WpcoWcz;

public class UpdateWpcoWcz implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateWpcoWcz me = new UpdateWpcoWcz();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "wpco_wcz";
		getAllFromMssql(con, em, dbName);

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

					WpcoWcz row = new WpcoWcz();
					row.setWczId(rs.getString("wcz_id"));
					row.setZoneId(rs.getString("zone_id"));
					row.setWczName(rs.getString("wcz_name"));
					row.setChineseName(rs.getString("chinese_name"));
					row.setWczLabel(rs.getString("wcz_label"));
					row.setWczAbbr(rs.getString("wcz_abbr"));
					row.setFad(rs.getTimestamp("fad"));
					row.setWczCode(rs.getBigDecimal("wcz_code"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));

//					System.err.println(row.getWczId());

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
