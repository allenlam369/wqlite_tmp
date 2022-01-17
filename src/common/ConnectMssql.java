package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class ConnectMssql {

	// MSSQL connection
//	 static String connectionUrl =
//	 "jdbc:sqlserver://10.17.61.111\\WQDB;databaseName=WQPLIS;user=MECC;password=Mecc123456";

	public static Connection getConnection() {
		java.security.Security.setProperty("jdk.tls.disabledAlgorithms",
				"SSLv3, RC4, DES, MD5withRSA, DH keySize < 1024,EC keySize < 224, 3DES_EDE_CBC, anon, NULL");

		String connectionUrl = PropertyLoader.getInstance().getProperty("connectionUrl");

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(connectionUrl);
			return con;
		}
		// Handle any errors that may have occurred.
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// for testing
	public static void main(String[] args) throws SQLException {

		Connection con = getConnection();

		if (con == null) {
			con = ConnectMssql.getConnection();
		}

		if (con != null) {
			Statement stmt = con.createStatement();

			String SQL = "SELECT * FROM WPG.bm_rain where sdatetime > '2021-09-01'";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out
						.println(rs.getString("ID") + " " + rs.getString("bmvisit_id") + " " + rs.getDate("sdatetime"));
			}

			con.close();
		}

	}

}