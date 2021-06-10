package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.Rstation;

public class UpdateRstation implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateRstation me = new UpdateRstation();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "rstation";
		String sql = Utils.getAllSql(dbName);
		updateAllFromMssql(con, em, sql);

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

					Rstation row = new Rstation();
					row.setSiteId(rs.getLong("site_id"));
					row.setStatname(rs.getString("statname"));
					row.setRId(rs.getString("r_id"));
					row.setSzId(rs.getString("sz_id"));
					row.setEasting(rs.getBigDecimal("easting"));
					row.setNorthing(rs.getBigDecimal("northing"));
					row.setLatitude(rs.getBigDecimal("latitude"));
					row.setLongitude(rs.getBigDecimal("longitude"));
					row.setStartDate(rs.getTimestamp("start_date"));
					row.setActive(rs.getString("active"));
					row.setShow(rs.getString("show"));
					row.setCmmview(rs.getBigDecimal("cmmview"));
					row.setWczCode(rs.getBigDecimal("wcz_code"));
					row.setWcszCode(rs.getBigDecimal("wcsz_code"));
					row.setRiverid(rs.getBigDecimal("riverId"));
					row.setStationId(rs.getBigDecimal("riverid"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));
					row.setEasting1(rs.getBigDecimal("easting1"));
					row.setNorthing1(rs.getBigDecimal("northing1"));
					row.setEndDate(rs.getTimestamp("end_date"));
					row.setActiveYear(rs.getBigDecimal("active_year"));

//					System.err.println(row.getSiteId());
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
