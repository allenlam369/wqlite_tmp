package dbUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConnectMssql;
import common.EntityManagerUtil;
import common.Utils;

/**
 * Truncate all these tables under obelix:5433.wqplis_lite.tmp_lite. Rebuild
 * table data of recent months by reading from MSSQL WPG.wqplis
 * 
 * Used for comparing tables in obelix:5433.wqplis_lite.public, to detect any
 * extra un-needed rows existing in pg tables.
 * 
 * The following steps will be handled by another program or script:
 * 
 * The extra un-needed rows will be copied to obelix:5433.wqplis_lite.del_bak,
 * and then deleted in obelix:5433.wqplis_lite.public
 * 
 * @author Allen Lam
 *
 */
public class UpdateAll {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
	static Logger log = LoggerFactory.getLogger(UpdateAll.class);
	static List<String> sList = new ArrayList<>();

	public static void main(String[] args) throws SQLException {
		// for mssql
		if (con == null) {
			con = ConnectMssql.getConnection();
		}
		// for postgres
		em.getTransaction().begin(); // only need to do it once

		String dbName1 = "ten_zone";
		String dbName2 = "wpco_wcz";
		String dbName3 = "wpco_sz";
		String dbName4 = "river";
		String dbName5 = "rstation";
		String dbName6 = "mstation";
		String dbName7 = "bm_beach";

		String dbName8 = "bm_beach_ec_agm_rank_report";
		String dbName9 = "bm_visit_label_summary";
		String dbName10 = "marine_water1";
		String dbName11 = "marine_water2";
		String dbName12 = "marine_water_wqo_raw1";
		String dbName13 = "river_water1";
		String dbName14 = "river_water2";
		String dbName15 = "river_water_wqi1";

		String dbName16 = "river_water_wqo_sum0";
		String dbName17 = "rw_wqi_avg";

		// --------------------------------------------------------------
		// truncate tables first
		// --------------------------------------------------------------
		System.out.println("Incremental update data from MSSQL to merge in Postgres");

		int count = 0;

		// for running updateAllFromMssql()
		Map<UpdateDbInterface, String> map1 = new LinkedHashMap<>();
		map1.put(new UpdateTenZone(), Utils.getAllSql(dbName1));
		map1.put(new UpdateWpcoWcz(), Utils.getAllSql(dbName2));
		map1.put(new UpdateWpcoSz(), Utils.getAllSql(dbName3));
		map1.put(new UpdateRiver(), Utils.getAllSql(dbName4));
		map1.put(new UpdateRstation(), Utils.getAllSql(dbName5));
		map1.put(new UpdateMstation(), Utils.getAllSql(dbName6));
		map1.put(new UpdateBmBeach(), Utils.getAllSql(dbName7));
		map1.put(new UpdateBeachRankReport(), Utils.getAllSql(dbName8));

		// for running incrementalUpdateFromMssql()
		// sql += " where mdate >= '" + lastMonth + "'";
		Map<UpdateDbInterface, String> map2 = new LinkedHashMap<>();
		map2.put(new UpdateBmVisitLabelSummary(), Utils.getAllSql(dbName9));
		map2.put(new UpdateMarineWater1(), Utils.getAllSql(dbName10));
		map2.put(new UpdateMarineWater2(), Utils.getAllSql(dbName11));
		map2.put(new UpdateMarineWaterWqoRaw1(), Utils.getAllSql(dbName12));
		map2.put(new UpdateRiverWater1(), Utils.getAllSql(dbName13));
		map2.put(new UpdateRiverWater2(), Utils.getAllSql(dbName14));
		map2.put(new UpdateRiverWaterWqi1(), Utils.getAllSql(dbName15));
		// sql += " where yr >= " + (yr - 2);
		map2.put(new UpdateRiverWaterWqoSum0(), Utils.getAllSql(dbName16));
		map2.put(new UpdateRwWqiAvg(), Utils.getAllSql(dbName17));

		for (Map.Entry<UpdateDbInterface, String> entry : map1.entrySet()) {
			String sql = entry.getValue();
			count = entry.getKey().updateAllFromMssql(con, em, sql);
			System.out.println(sql + " ->update count: " + count);
			log.info(sql + " " + count);
		}

		for (Map.Entry<UpdateDbInterface, String> entry : map2.entrySet()) {
			String sql = entry.getValue();
			count = entry.getKey().incrementalUpdateFromMssql(con, em, sql);
			System.out.println(sql + " ->update count: " + count);
			log.info(sql + " " + count);
		}

		// --------------------------------------------------------------
		em.getTransaction().commit();
		em.close();
		con.close();

		System.out.println("DONE");

		for (String s : sList) {
			System.out.println(s);
		}
	}
}
