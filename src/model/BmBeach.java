package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the bm_beach database table.
 * 
 */
@Entity
@Table(name="bm_beach")
@NamedQuery(name="BmBeach.findAll", query="SELECT b FROM BmBeach b")
public class BmBeach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="beach_code")
	private String beachCode;

	@Column(name="beach_name")
	private String beachName;

	@Column(name="chinese_name")
	private String chineseName;

	@Column(name="district_code")
	private String districtCode;

	private BigDecimal easting;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private BigDecimal northing;

	@Column(name="rain_station_code")
	private String rainStationCode;

	private String remark;

	@Column(name="sc_name")
	private String scName;

	@Column(name="site_id")
	private BigDecimal siteId;

	@Column(name="sz_id")
	private String szId;

	@Column(name="tide_station_code")
	private String tideStationCode;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="wcz_code")
	private BigDecimal wczCode;

	public BmBeach() {
	}

	public String getBeachCode() {
		return this.beachCode;
	}

	public void setBeachCode(String beachCode) {
		this.beachCode = beachCode;
	}

	public String getBeachName() {
		return this.beachName;
	}

	public void setBeachName(String beachName) {
		this.beachName = beachName;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getDistrictCode() {
		return this.districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public BigDecimal getEasting() {
		return this.easting;
	}

	public void setEasting(BigDecimal easting) {
		this.easting = easting;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getNorthing() {
		return this.northing;
	}

	public void setNorthing(BigDecimal northing) {
		this.northing = northing;
	}

	public String getRainStationCode() {
		return this.rainStationCode;
	}

	public void setRainStationCode(String rainStationCode) {
		this.rainStationCode = rainStationCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScName() {
		return this.scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}

	public BigDecimal getSiteId() {
		return this.siteId;
	}

	public void setSiteId(BigDecimal siteId) {
		this.siteId = siteId;
	}

	public String getSzId() {
		return this.szId;
	}

	public void setSzId(String szId) {
		this.szId = szId;
	}

	public String getTideStationCode() {
		return this.tideStationCode;
	}

	public void setTideStationCode(String tideStationCode) {
		this.tideStationCode = tideStationCode;
	}

	public BigDecimal getValidCode() {
		return this.validCode;
	}

	public void setValidCode(BigDecimal validCode) {
		this.validCode = validCode;
	}

	public Timestamp getValidDate() {
		return this.validDate;
	}

	public void setValidDate(Timestamp validDate) {
		this.validDate = validDate;
	}

	public String getValidUser() {
		return this.validUser;
	}

	public void setValidUser(String validUser) {
		this.validUser = validUser;
	}

	public BigDecimal getWczCode() {
		return this.wczCode;
	}

	public void setWczCode(BigDecimal wczCode) {
		this.wczCode = wczCode;
	}

}