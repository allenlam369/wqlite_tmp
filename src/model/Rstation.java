package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the rstation database table.
 * 
 */
@Entity
@NamedQuery(name="Rstation.findAll", query="SELECT r FROM Rstation r")
public class Rstation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="site_id")
	private long siteId;

	private String active;

	@Column(name="active_year")
	private BigDecimal activeYear;

	private BigDecimal cmmview;

	private BigDecimal easting;

	private BigDecimal easting1;

	@Column(name="end_date")
	private Timestamp endDate;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private BigDecimal northing;

	private BigDecimal northing1;

	@Column(name="r_id")
	private String rId;

	private BigDecimal riverid;

	private String show;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="station_id")
	private BigDecimal stationId;

	private String statname;

	@Column(name="sz_id")
	private String szId;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="wcsz_code")
	private BigDecimal wcszCode;

	@Column(name="wcz_code")
	private BigDecimal wczCode;

	public Rstation() {
	}

	public long getSiteId() {
		return this.siteId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public BigDecimal getActiveYear() {
		return this.activeYear;
	}

	public void setActiveYear(BigDecimal activeYear) {
		this.activeYear = activeYear;
	}

	public BigDecimal getCmmview() {
		return this.cmmview;
	}

	public void setCmmview(BigDecimal cmmview) {
		this.cmmview = cmmview;
	}

	public BigDecimal getEasting() {
		return this.easting;
	}

	public void setEasting(BigDecimal easting) {
		this.easting = easting;
	}

	public BigDecimal getEasting1() {
		return this.easting1;
	}

	public void setEasting1(BigDecimal easting1) {
		this.easting1 = easting1;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
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

	public BigDecimal getNorthing1() {
		return this.northing1;
	}

	public void setNorthing1(BigDecimal northing1) {
		this.northing1 = northing1;
	}

	public String getRId() {
		return this.rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public BigDecimal getRiverid() {
		return this.riverid;
	}

	public void setRiverid(BigDecimal riverid) {
		this.riverid = riverid;
	}

	public String getShow() {
		return this.show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public BigDecimal getStationId() {
		return this.stationId;
	}

	public void setStationId(BigDecimal stationId) {
		this.stationId = stationId;
	}

	public String getStatname() {
		return this.statname;
	}

	public void setStatname(String statname) {
		this.statname = statname;
	}

	public String getSzId() {
		return this.szId;
	}

	public void setSzId(String szId) {
		this.szId = szId;
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

	public BigDecimal getWcszCode() {
		return this.wcszCode;
	}

	public void setWcszCode(BigDecimal wcszCode) {
		this.wcszCode = wcszCode;
	}

	public BigDecimal getWczCode() {
		return this.wczCode;
	}

	public void setWczCode(BigDecimal wczCode) {
		this.wczCode = wczCode;
	}

}