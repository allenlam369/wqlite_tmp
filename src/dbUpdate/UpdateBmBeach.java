package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.BmBeach;

public class UpdateBmBeach implements UpdateDbInterface {

	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "bm_beach";

	public static void main(String[] args) throws SQLException {
		UpdateBmBeach me = new UpdateBmBeach();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}

		// for postgres
		em.getTransaction().begin(); // only need to do it once

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

	// read all rows from mssql table; update to postgres table
	public int updateAllFromMssql(Connection con, EntityManager em, String sql) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					BmBeach row = new BmBeach();
					row.setSiteId(rs.getBigDecimal("site_id"));
					row.setBeachCode(rs.getString("beach_code"));
					row.setBeachName(rs.getString("beach_name"));
					row.setChineseName(rs.getString("chinese_name"));
					row.setScName(rs.getString("sc_name"));
					row.setDistrictCode(rs.getString("district_code"));
					row.setRainStationCode(rs.getString("rain_station_code"));
					row.setTideStationCode(rs.getString("tide_station_code"));
					row.setRemark(rs.getString("remark"));
					row.setSzId(rs.getString("sz_id"));
					row.setEasting(rs.getBigDecimal("easting"));
					row.setNorthing(rs.getBigDecimal("northing"));
					row.setLatitude(rs.getBigDecimal("latitude"));
					row.setLongitude(rs.getBigDecimal("longitude"));
					row.setWczCode(rs.getBigDecimal("wcz_code"));
					row.setValidUser(rs.getString("valid_user"));
					row.setValidDate(rs.getTimestamp("valid_date"));
					row.setValidCode(rs.getBigDecimal("valid_code"));

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

	// truncate table in postgres
//	09:48:11.981 [main] ERROR org.hibernate.engine.jdbc.spi.SqlExceptionHelper - ERROR: cannot truncate a table referenced in a foreign key constraint
//	  Detail: Table "bm_visit_label_summary" references "bm_beach".
//	  Hint: Truncate table "bm_visit_label_summary" at the same time, or use TRUNCATE ... CASCADE.
	private void truncatePostgresTable() {
		String sql = "TRUNCATE TABLE " + dbName;
		System.out.println(sql);
		em.createNativeQuery(sql).executeUpdate();

//		em.createQuery("DELETE FROM " + myClass.getName() + " e").executeUpdate();
	}

}
