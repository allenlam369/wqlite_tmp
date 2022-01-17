package dbUpdate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.ConnectMssql;
import common.EntityManagerUtil;
import common.Utils;

public class UpdateAll {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres
//	static Logger log = Logger.getLogger(UpdateAll.class.getName());
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
		String dbName10 = "marine_water1"; // new
		String dbName11 = "marine_water2";
		String dbName12 = "marine_water_wqo_raw1"; // new
		String dbName13 = "river_water1"; // new
		String dbName14 = "river_water2";
		String dbName15 = "river_water_wqi1"; // new
		String dbName16 = "river_water_wqo_sum0";
		String dbName17 = "rw_wqi_avg";

		// --------------------------------------------------------------
		System.out.println("Incremental update data from MSSQL to merge in Postgres");

		sList.add(Utils.getAllSql(dbName1));
		sList.add(Utils.getAllSql(dbName2));
		sList.add(Utils.getAllSql(dbName3));
		sList.add(Utils.getAllSql(dbName4));
		sList.add(Utils.getAllSql(dbName5));
		sList.add(Utils.getAllSql(dbName6));
		sList.add(Utils.getAllSql(dbName7));
		sList.add(Utils.getAllSql(dbName8));

		int count = 0;
		UpdateDbInterface u;

		u = new UpdateTenZone();

		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName1));
		System.out.println(dbName1 + " " + count);
		log.info(dbName1 + " " + count);

		u = new UpdateWpcoWcz();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName2));
		System.out.println(dbName2 + " " + count);
		log.info(dbName2 + " " + count);

		u = new UpdateWpcoSz();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName3));
		System.out.println(dbName3 + " " + count);
		log.info(dbName3 + " " + count);

		u = new UpdateRiver();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName4));
		System.out.println(dbName4 + " " + count);
		log.info(dbName4 + " " + count);

		u = new UpdateRstation();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName5));
		System.out.println(dbName5 + " " + count);
		log.info(dbName5 + " " + count);

		u = new UpdateMstation();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName6));
		System.out.println(dbName6 + " " + count);
		log.info(dbName6 + " " + count);

		u = new UpdateBmBeach();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName7));
		System.out.println(dbName7 + " " + count);
		log.info(dbName7 + " " + count);

		u = new UpdateBeachRankReport();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName8));
		System.out.println(dbName8 + " " + count);
		log.info(dbName8 + " " + count);

		// -------------------------------------------------
		// incremental update
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateBmVisitLabelSummary();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName9));
		System.out.println(dbName9 + " " + count);
		log.info(dbName9 + " " + count);

		// --------10
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateMarineWater1();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName10));
		System.out.println(dbName10 + " " + count);
		log.info(dbName10 + " " + count);

		// incremental update
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateMarineWater2();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName11));
		System.out.println(dbName11 + " " + count);
		log.info(dbName11 + " " + count);

		// 12
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateMarineWaterWqoRaw1();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName12));
		System.out.println(dbName12 + " " + count);
		log.info(dbName12 + " " + count);

		// new 13
		// incremental update
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateRiverWater1();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName13));
		System.out.println(dbName13 + " " + count);
		log.info(dbName13 + " " + count);

		// incremental update
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateRiverWater2();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName14));
		System.out.println(dbName14 + " " + count);
		log.info(dbName14 + " " + count);

		// 15
		// sql += " where mdate >= '" + lastMonth + "'";
		u = new UpdateRiverWaterWqi1();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName15));
		System.out.println(dbName15 + " " + count);
		log.info(dbName15 + " " + count);

		// incremental update
		// sql += " where yr >= " + (yr - 2);
		u = new UpdateRiverWaterWqoSum0();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName16));
		System.out.println(dbName16 + " " + count);
		log.info(dbName16 + " " + count);

		// incremental update
		// sql += " where yr >= " + (yr - 2);
		u = new UpdateRwWqiAvg();
		count = u.incrementalUpdateFromMssql(con, em, Utils.getAllSql(dbName17));
		System.out.println(dbName17 + " " + count);
		log.info(dbName17 + " " + count);

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
