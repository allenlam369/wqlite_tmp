package dbUpdate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import model.BmVisitLabelSummary;
import model.BmVisitLabelSummaryPK;

public class UpdateBmVisitLabelSummary implements UpdateDbInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAllFromMssql(Connection con, EntityManager em, String dbName) {
		try {
			if (con != null) {

				Statement stmt = con.createStatement();
				String sql = "select * from wpg." + dbName;
				ResultSet rs = stmt.executeQuery(sql);

				int i = 0;
				while (rs.next()) {
					i++;

					BmVisitLabelSummary row = new BmVisitLabelSummary();
					
					row.setDistrictName(rs.getString("district_name"));
					row.setBeachName(rs.getString("beach_name"));
					row.setBeachGroup(rs.getString("beach_group"));
					row.setClosed(rs.getString("closed"));
					row.setDistrictOrder(rs.getString("district_order"));
					row.setListOrder(rs.getString("list_order"));
					row.setBmvisitId(rs.getString("bmvisit_id"));
					row.setSiteId(rs.getBigDecimal("site_id"));
					row.setMdate(rs.getTimestamp("mdate"));
					row.setStime(rs.getBigDecimal("stime"));
					row.setSampleNo(rs.getBigDecimal("sample_no"));
					
					BmVisitLabelSummaryPK pk = new BmVisitLabelSummaryPK();
					pk.setBeachCode(rs.getString("beach_code"));
					pk.setSampleDate(rs.getDate("sample_date"));
					
					row.setId(pk);
					row.setSampleTime(rs.getString("sample_time"));
					row.setTemper(rs.getBigDecimal("temper"));
					row.setDo_(rs.getBigDecimal("do"));
					row.setDos(rs.getBigDecimal("dos"));
					row.setSal(rs.getBigDecimal("sal"));
					row.setSalR(rs.getBigDecimal("sal_r"));
					row.setSalM(rs.getBigDecimal("sal_m"));
					row.setSalL(rs.getBigDecimal("sal_l"));
					row.setSalO(rs.getBigDecimal("sal_o"));
					row.setPh(rs.getBigDecimal("ph"));
					row.setTurb(rs.getBigDecimal("turb"));
					row.setWeatherValue(rs.getBigDecimal("weather_value"));
					row.setWindValue(rs.getBigDecimal("wind_value"));
					row.setClimateValue(rs.getBigDecimal("climate_value"));
					row.setSeaClarityValue(rs.getBigDecimal("sea_clarity_value"));
					
					
					
					
					
					row.setRainStationCode(rs.getString("rain_station_code"));
					row.setTideStationCode(rs.getString("tide_station_code"));


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
