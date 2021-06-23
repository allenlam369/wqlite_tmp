package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import model.MarineWater1;
import model.MarineWater1PK;

public class UpdateMarineWater1 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) throws SQLException {
		UpdateMarineWater1 me = new UpdateMarineWater1();
		me.run();
	}

	void run() throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName = "marine_water1";
		String sql = Utils.getAllSql(dbName);
		int count = incrementalUpdateFromMssql(con, em, sql);
		System.err.println("count = " + count);

		em.getTransaction().commit();
		em.close();
		con.close();
	}

	public int incrementalUpdateFromMssql(Connection con, EntityManager em, String sql) {
		int count = 0;
		try {
			Timestamp ts2 = null;
			if (con != null) {
				Statement stmt = con.createStatement();
				String sql1 = "SELECT top 1 mdate FROM [WPG].[MARINE_WATER1] order by mdate DESC";
				ResultSet rs = stmt.executeQuery(sql1);

				// Iterate through the data in the result set and display it.
				if (rs.next()) {
					Timestamp ts = rs.getTimestamp("mdate");
					ts2 = Utils.previous2Years(ts);
				}

				sql += " where mdate >= '" + ts2 + "'";
				System.err.println(sql);

				count = updateAllFromMssql(con, em, sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

					MarineWater1 row = new MarineWater1();
					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));

					MarineWater1PK id = new MarineWater1PK();
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
					row.setLPhM(rs.getString("l_ph_m"));
					row.setPhM(rs.getBigDecimal("ph_m"));
					row.setLTurbM(rs.getString("l_turb_m"));
					row.setTurbM(rs.getBigDecimal("turb_m"));
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
					row.setTin(rs.getBigDecimal("tin"));
					row.setTn(rs.getBigDecimal("tn"));
					row.setNh3(rs.getBigDecimal("nh3"));
					row.setSolRad(rs.getBigDecimal("sol_rad"));
					row.setAirTemp(rs.getBigDecimal("air_temp"));
					row.setWindSp(rs.getBigDecimal("wind_sp"));
					row.setWindDir(rs.getBigDecimal("wind_dir"));
					row.setSeaCond(rs.getString("sea_cond"));
					row.setSeaCol(rs.getString("sea_col"));
					row.setFishKill(rs.getString("fish_kill"));
					row.setSd(rs.getBigDecimal("sd"));
					row.setWeather(rs.getString("weather"));
					row.setNh4Nm(rs.getBigDecimal("nh4_nm"));
					row.setNo2Nm(rs.getBigDecimal("no2_nm"));
					row.setNo3Nm(rs.getBigDecimal("no3_nm"));
					row.setTknNm(rs.getBigDecimal("tkn_nm"));
					row.setNoxNm(rs.getBigDecimal("nox_nm"));
					row.setTinNm(rs.getBigDecimal("tin_nm"));
					row.setTnNm(rs.getBigDecimal("tn_nm"));
					row.setPo4Pm(rs.getBigDecimal("po4_pm"));
					row.setTpPm(rs.getBigDecimal("tp_pm"));
					row.setTinPo4Mmr(rs.getBigDecimal("tin_po4_mmr"));
					row.setTnTpMmr(rs.getBigDecimal("tn_tp_mmr"));
					row.setViewNo(rs.getBigDecimal("view_no"));
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
