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
import model.RiverWater1;
import model.RiverWater1PK;

public class UpdateRiverWater1 implements UpdateDbInterface {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static String dbName = "river_water1";

	public static void main(String[] args) throws SQLException {
		UpdateRiverWater1 me = new UpdateRiverWater1();
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
		int count = updateAllFromMssql(con, em, sql);
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
				String sql1 = "SELECT top 1 mdate FROM WPG.river_water1 order by mdate DESC";
				ResultSet rs = stmt.executeQuery(sql1);

				// Iterate through the data in the result set and display it.
				if (rs.next()) {
					Timestamp ts = rs.getTimestamp("mdate");
					ts2 = Utils.lastMonth(ts);
				}

				sql += " where mdate >= '" + ts2 + "'";
				System.err.println(sql);
				UpdateAll.sList.add(sql);

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
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					RiverWater1 row = new RiverWater1();

					row.setZone(rs.getString("zone"));
					row.setWcz(rs.getString("wcz"));
					row.setSubzone(rs.getString("subzone"));
					row.setRiver(rs.getString("river"));

					RiverWater1PK id = new RiverWater1PK();
					id.setStation(rs.getString("station"));
					id.setMdate(rs.getDate("mdate"));
					row.setId(id);

					row.setStime(rs.getBigDecimal("stime"));
					row.setSampleNo(rs.getInt("sample_no"));
					row.setLSal(rs.getString("l_sal"));
					row.setSal(rs.getBigDecimal("sal"));
					row.setLCond(rs.getString("l_cond"));
					row.setCond(rs.getBigDecimal("cond"));
					row.setLDo(rs.getString("l_do"));
					row.setDo_(rs.getBigDecimal("do"));
					row.setLDos(rs.getString("l_dos"));
					row.setDos(rs.getBigDecimal("dos"));
					row.setLPh(rs.getString("l_ph"));
					row.setPh(rs.getBigDecimal("ph"));
					row.setTemper(rs.getBigDecimal("temper"));
					row.setLSs(rs.getString("l_ss"));
					row.setSs(rs.getBigDecimal("ss"));
					row.setLTs(rs.getString("l_ts"));
					row.setTs(rs.getBigDecimal("ts"));
					row.setLTvs(rs.getString("l_tvs"));
					row.setTvs(rs.getBigDecimal("tvs"));
					row.setLTurb(rs.getString("l_turb"));
					row.setTurb(rs.getBigDecimal("turb"));
					row.setLBod5(rs.getString("l_bod5"));
					row.setBod5(rs.getBigDecimal("bod5"));
					row.setLCod(rs.getString("l_cod"));
					row.setCod(rs.getBigDecimal("cod"));
					row.setLToc(rs.getString("l_toc"));
					row.setToc(rs.getBigDecimal("toc"));
					row.setLOil(rs.getString("l_oil"));
					row.setOil(rs.getBigDecimal("oil"));
					row.setLEc(rs.getString("l_ec"));
					row.setEc(rs.getBigDecimal("ec"));
					row.setLOil(rs.getString("l_oil"));
					row.setOil(rs.getBigDecimal("oil"));
					row.setLFc(rs.getString("l_fc"));
					row.setFc(rs.getBigDecimal("fc"));
					row.setLNh4(rs.getString("l_nh4"));
					row.setNh4(rs.getBigDecimal("nh4"));
					row.setLNo2(rs.getString("l_no2"));
					row.setNo2(rs.getBigDecimal("no2"));
					row.setLNo3(rs.getString("l_no3"));
					row.setNo3(rs.getBigDecimal("no3"));
					row.setLTkns(rs.getString("l_tkns"));
					row.setTkns(rs.getBigDecimal("tkns"));
					row.setLTknsp(rs.getString("l_tknsp"));
					row.setTknsp(rs.getBigDecimal("tknsp"));
					row.setLPo4(rs.getString("l_po4"));
					row.setPo4(rs.getBigDecimal("po4"));
					row.setLTps(rs.getString("l_tps"));
					row.setTps(rs.getBigDecimal("tps"));
					row.setLTpsp(rs.getString("l_tpsp"));
					row.setTpsp(rs.getBigDecimal("tpsp"));
					row.setLSil(rs.getString("l_sil"));
					row.setSil(rs.getBigDecimal("sil"));
					row.setLTcyn(rs.getString("l_tcyn"));
					row.setTcyn(rs.getBigDecimal("tcyn"));
					row.setLDeterg(rs.getString("l_deterg"));
					row.setDeterg(rs.getBigDecimal("deterg"));
					row.setLFl(rs.getString("l_fl"));
					row.setFl(rs.getBigDecimal("fl"));
					row.setLCl(rs.getString("l_cl"));
					row.setCl(rs.getBigDecimal("cl"));
					row.setLH2s(rs.getString("l_h2s"));
					row.setH2s(rs.getBigDecimal("h2s"));
					row.setLSulp(rs.getString("l_sulp"));
					row.setSulp(rs.getBigDecimal("sulp"));
					row.setLSsp(rs.getString("l_ssp"));
					row.setSsp(rs.getBigDecimal("ssp"));
					row.setLChl(rs.getString("l_chl"));
					row.setChl(rs.getBigDecimal("chl"));
					row.setLPheo(rs.getString("l_pheo"));
					row.setPheo(rs.getBigDecimal("pheo"));
					row.setLAl(rs.getString("l_al"));
					row.setAl(rs.getBigDecimal("al"));
					row.setLSb(rs.getString("l_sb"));
					row.setSb(rs.getBigDecimal("sb"));
					row.setLArsenic(rs.getString("l_arsenic"));
					row.setArsenic(rs.getBigDecimal("arsenic"));
					row.setLBa(rs.getString("l_ba"));
					row.setBa(rs.getBigDecimal("ba"));
					row.setLBe(rs.getString("l_be"));
					row.setBe(rs.getBigDecimal("be"));
					row.setLB(rs.getString("l_b"));
					row.setB(rs.getBigDecimal("b"));
					row.setLCd(rs.getString("l_cd"));
					row.setCd(rs.getBigDecimal("cd"));
					row.setLCr(rs.getString("l_cr"));
					row.setCr(rs.getBigDecimal("cr"));
					row.setLCu(rs.getString("l_cu"));
					row.setCu(rs.getBigDecimal("cu"));
					row.setLFe(rs.getString("l_fe"));
					row.setFe(rs.getBigDecimal("fe"));
					
					row.setLPb(rs.getString("l_pb"));
					row.setPb(rs.getBigDecimal("pb"));
					row.setLMn(rs.getString("l_mn"));
					row.setMn(rs.getBigDecimal("mn"));
					row.setLHg(rs.getString("l_hg"));
					row.setHg(rs.getBigDecimal("hg"));
					row.setLMo(rs.getString("l_mo"));
					row.setMo(rs.getBigDecimal("mo"));
					row.setLNi(rs.getString("l_ni"));
					row.setNi(rs.getBigDecimal("ni"));
					row.setLAg(rs.getString("l_ag"));
					row.setAg(rs.getBigDecimal("ag"));
					row.setLTl(rs.getString("l_tl"));
					row.setTl(rs.getBigDecimal("tl"));
					row.setLV(rs.getString("l_v"));
					row.setV(rs.getBigDecimal("v"));
					row.setLZn(rs.getString("l_zn"));
					row.setZn(rs.getBigDecimal("zn"));
					row.setDepth(rs.getBigDecimal("depth"));
					row.setWidth(rs.getBigDecimal("width"));
					row.setVel(rs.getBigDecimal("vel"));
					row.setFlow(rs.getBigDecimal("flow"));
					row.setBod5Pt(rs.getBigDecimal("bod5_pt"));
					row.setNh4Pt(rs.getBigDecimal("nh4_pt"));
					row.setDosPt(rs.getBigDecimal("dos_pt"));
					row.setWqiPt(rs.getBigDecimal("wqi_pt"));
					row.setWqiGrade(rs.getString("wqi_grade"));
					row.setLNh3(rs.getString("l_nh3"));
					row.setNh3(rs.getBigDecimal("nh3"));
					row.setTin(rs.getBigDecimal("tin"));
					row.setTn(rs.getBigDecimal("tn"));
					row.setWeather(rs.getString("weather"));
					row.setColor(rs.getString("color"));
					row.setSmell(rs.getString("smell"));
					row.setRainfall(rs.getString("rainfall"));
					row.setTide(rs.getString("tide"));
					row.setRemark(rs.getString("remark"));

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
	private void truncatePostgresTable() {
		String sql = "TRUNCATE TABLE " + dbName;
		System.out.println(sql);
		em.createNativeQuery(sql).executeUpdate();
	}
}
