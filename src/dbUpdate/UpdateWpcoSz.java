package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.WpcoSz;
import model.WpcoWcz;

public class UpdateWpcoSz implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateWpcoSz me = new UpdateWpcoSz();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "wpco_sz";
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

					WpcoSz row = new WpcoSz();
					row.setSzId(rs.getString("sz_id"));

					WpcoWcz pk = new WpcoWcz();
					pk.setWczId(rs.getString("wcz_id"));
					row.setWpcoWcz(pk);

					row.setSzName(rs.getString("sz_name"));
					row.setChineseName(rs.getString("chinese_name"));
					row.setMarineInland(rs.getString("marine_inland"));
					row.setWpcoSubleg(rs.getString("wpco_subleg"));
					row.setWcszCode(rs.getBigDecimal("wcsz_code"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));

//					System.err.println(row.getWpcoWcz().getWczId());

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