package common_pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectPostgres {

	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(Props.url, Props.user, Props.pass);
			return con;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// for testing
	public static void main(String[] args) throws SQLException {
		Connection con = getConnection();

		if (con != null) {
			Statement stmt = con.createStatement();

			String SQL = "SELECT * FROM public.tide";
			ResultSet rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("station") + " " + rs.getDate("datetime") + " "
						+ rs.getDouble("height"));
			}

			con.close();
		}

	}

}