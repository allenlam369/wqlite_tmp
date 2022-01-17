package dbUpdate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import common.ConnectMssql;
import common.EntityManagerUtil;
import common.Utils;

public class FetchAll {
	static Connection con; // for mssql
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

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
		
		System.out.println("Fetch All data from MSSQL to merge in Postgres");

		int count = 0;
		UpdateDbInterface u;

		u = new UpdateTenZone();

		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName1));
		System.out.println(dbName1 + " " + count);

		u = new UpdateWpcoWcz();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName2));
		System.out.println(dbName2 + " " + count);

		u = new UpdateWpcoSz();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName3));
		System.out.println(dbName3 + " " + count);

		u = new UpdateRiver();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName4));
		System.out.println(dbName4 + " " + count);

		u = new UpdateRstation();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName5));
		System.out.println(dbName5 + " " + count);

		u = new UpdateMstation();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName6));
		System.out.println(dbName6 + " " + count);

		u = new UpdateBmBeach();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName7));
		System.out.println(dbName7 + " " + count);

		u = new UpdateBeachRankReport();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName8));
		System.out.println(dbName8 + " " + count);

		// -------------------------------------------------
		u = new UpdateBmVisitLabelSummary();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName9));
		System.out.println(dbName9 + " " + count);

		u = new UpdateMarineWater1();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName10));
		System.out.println(dbName10 + " " + count);

		u = new UpdateMarineWater2();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName11));
		System.out.println(dbName11 + " " + count);

		u = new UpdateMarineWaterWqoRaw1();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName12));
		System.out.println(dbName12 + " " + count);

		u = new UpdateRiverWater1();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName13));
		System.out.println(dbName13 + " " + count);

		u = new UpdateRiverWater2();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName14));
		System.out.println(dbName14 + " " + count);

		u = new UpdateRiverWaterWqi1();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName15));
		System.out.println(dbName15 + " " + count);

		u = new UpdateRiverWaterWqoSum0();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName16));
		System.out.println(dbName16 + " " + count);

		u = new UpdateRwWqiAvg();
		count = u.updateAllFromMssql(con, em, Utils.getAllSql(dbName17));
		System.out.println(dbName17 + " " + count);

		// --------------------------------------------------------------
		em.getTransaction().commit();
		em.close();
		con.close();

		System.out.println("DONE");
	}

}
