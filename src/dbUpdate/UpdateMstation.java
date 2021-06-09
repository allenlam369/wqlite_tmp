package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.Mstation;

public class UpdateMstation implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateMstation me = new UpdateMstation();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "mstation";
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

					Mstation row = new Mstation();
					row.setSiteId(rs.getLong("site_id"));
					row.setMwName(rs.getString("mw_name"));
					row.setMsName(rs.getString("ms_name"));
					row.setMwTsName(rs.getString("mw_ts_name"));
					row.setMsTsName(rs.getString("ms_ts_name"));
					row.setMsDxName(rs.getString("ms_dx_name"));
					row.setHsName(rs.getString("hs_name"));
					row.setDepth(rs.getBigDecimal("depth"));
					row.setSzId(rs.getString("sz_id"));
					row.setEasting(rs.getBigDecimal("easting"));
					row.setNorthing(rs.getBigDecimal("northing"));
					row.setLatitude(rs.getBigDecimal("latitude"));
					row.setLongitude(rs.getBigDecimal("longitude"));
					row.setEnvironment(rs.getString("environment"));
					row.setStartDate(rs.getTimestamp("start_date"));
					row.setActive(rs.getString("active"));
					row.setShow(rs.getString("show"));
					row.setCmmview(rs.getBigDecimal("cmmview"));
					row.setWczCode(rs.getBigDecimal("wcz_code"));
					row.setMwId(rs.getBigDecimal("mw_id"));
					row.setMsId(rs.getBigDecimal("ms_id"));
					row.setStationId(rs.getBigDecimal("station_id"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));
					row.setEasting1(rs.getBigDecimal("easting1"));
					row.setNorthing1(rs.getBigDecimal("northing1"));

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
