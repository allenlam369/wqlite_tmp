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
import model.MarineWater2;
import model.MarineWater2PK;

public class UpdateMarineWater2 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "marine_water2";

	public static void main(String[] args) throws SQLException {
		UpdateMarineWater2 me = new UpdateMarineWater2();
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

				if (sql.contains("where")) {
					sql += " and station is not null and d_code is not null";
				} else {
					sql += " where station is not null and d_code is not null";
				}

				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					MarineWater2 row = new MarineWater2();
					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));

					MarineWater2PK id = new MarineWater2PK();
					id.setStation(rs.getString("station"));
					id.setMdate(rs.getDate("mdate"));
					id.setDCode(rs.getString("d_code"));
					row.setId(id);

					row.setStime(rs.getBigDecimal("stime"));
					row.setSamNo(rs.getBigDecimal("sam_no"));
					row.setTemper(rs.getBigDecimal("temper"));
					row.setPhSc(rs.getBigDecimal("ph_sc"));
					row.setSal(rs.getBigDecimal("sal"));
					row.setCond(rs.getBigDecimal("cond"));
					row.setDo_(rs.getBigDecimal("do"));
					row.setDoSat(rs.getBigDecimal("do_sat"));
					row.setFlscufa(rs.getBigDecimal("flscufa"));
					row.setTurbSc(rs.getBigDecimal("turb_sc"));
					row.setPar(rs.getBigDecimal("par"));
					row.setLBod5(rs.getString("l_bod5"));
					row.setBod5(rs.getBigDecimal("bod5"));
					row.setLFc(rs.getString("l_fc"));
					row.setFc(rs.getDouble("fc"));
					row.setLEcoli(rs.getString("l_ecoli"));
					row.setEcoli(rs.getDouble("ecoli"));
					row.setLNh4(rs.getString("l_nh4"));
					row.setNh4(rs.getBigDecimal("nh4"));
					row.setLNo2(rs.getString("l_no2"));
					row.setNo2(rs.getBigDecimal("no2"));
					row.setLNo3(rs.getString("l_no3"));
					row.setNo3(rs.getBigDecimal("no3"));
					row.setLTknS(rs.getString("l_tkn_s"));
					row.setTknS(rs.getBigDecimal("tkn_s"));
					row.setLTknP(rs.getString("l_tkn_p"));
					row.setTknP(rs.getBigDecimal("tkn_p"));
					row.setLTknSp(rs.getString("l_tkn_sp"));
					row.setTknSp(rs.getBigDecimal("tkn_sp"));
					row.setLPo4(rs.getString("l_po4"));
					row.setPo4(rs.getBigDecimal("po4"));
					row.setLTpS(rs.getString("l_tp_s"));
					row.setTpS(rs.getBigDecimal("tp_s"));
					row.setLTpP(rs.getString("l_tp_p"));
					row.setTpP(rs.getBigDecimal("tp_p"));
					row.setLTpSp(rs.getString("l_tp_sp"));
					row.setTpSp(rs.getBigDecimal("tp_sp"));
					row.setLSio2(rs.getString("l_sio2"));
					row.setSio2(rs.getBigDecimal("sio2"));
					row.setLSs(rs.getString("l_ss"));
					row.setSs(rs.getBigDecimal("ss"));
					row.setLTvs(rs.getString("l_tvs"));
					row.setTvs(rs.getBigDecimal("tvs"));
					row.setLChl(rs.getString("l_chl"));
					row.setChl(rs.getBigDecimal("chl"));
					row.setLPhae(rs.getString("l_phae"));
					row.setPhae(rs.getBigDecimal("phae"));
					row.setSolRad(rs.getBigDecimal("sol_rad"));
					row.setAirTemp(rs.getBigDecimal("air_temp"));
					row.setWindSp(rs.getBigDecimal("wind_sp"));
					row.setWindDir(rs.getBigDecimal("wind_dir"));
					row.setSeaCond(rs.getString("sea_cond"));
					row.setSeaCol(rs.getString("sea_col"));
					row.setFishKill(rs.getString("fish_kill"));
					row.setSd(rs.getBigDecimal("sd"));
					row.setWeather(rs.getString("weather"));
					row.setNh3(rs.getBigDecimal("nh3"));
					row.setTin(rs.getBigDecimal("tin"));
					row.setTn(rs.getBigDecimal("tn"));

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
