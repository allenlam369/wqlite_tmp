package dbUpdate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

public class UpdateAll {
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
		String dbName10 = "marine_water2";
		String dbName11 = "river_water2";
		String dbName12 = "river_water_wqo_sum0";
		String dbName13 = "rw_wqi_avg";

		// --------------------------------------------------------------

		int count = 0;
		UpdateDbInterface u;

		u = new UpdateTenZone();
		count = u.getAllFromMssql(con, em, dbName1);
		System.out.println(dbName1 + " " + count);

		u = new UpdateWpcoWcz();
		count = u.getAllFromMssql(con, em, dbName2);
		System.out.println(dbName2 + " " + count);

		u = new UpdateWpcoSz();
		count = u.getAllFromMssql(con, em, dbName3);
		System.out.println(dbName3 + " " + count);

		u = new UpdateRiver();
		count = u.getAllFromMssql(con, em, dbName4);
		System.out.println(dbName4 + " " + count);

		u = new UpdateRstation();
		count = u.getAllFromMssql(con, em, dbName5);
		System.out.println(dbName5 + " " + count);

		u = new UpdateMstation();
		count = u.getAllFromMssql(con, em, dbName6);
		System.out.println(dbName6 + " " + count);

		u = new UpdateBmBeach();
		count = u.getAllFromMssql(con, em, dbName7);
		System.out.println(dbName7 + " " + count);
		
		u = new UpdateBeachRankReport();
		count = u.getAllFromMssql(con, em, dbName8);
		System.out.println(dbName8 + " " + count);

		u = new UpdateBmVisitLabelSummary();
		count = u.getAllFromMssql(con, em, dbName9);
		System.out.println(dbName9 + " " + count);

		
//		UpdateMstation me22 = new UpdateMstation();
//		me22.run();
//
//		UpdateBeachRankReport me33 = new UpdateBeachRankReport();
//		me33.run();

		// --------------------------------------------------------------
		em.getTransaction().commit();
		em.close();
		con.close();
	}

}
