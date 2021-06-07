package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the mstation database table.
 * 
 */
@Entity
@NamedQuery(name="Mstation.findAll", query="SELECT m FROM Mstation m")
public class Mstation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="site_id")
	private long siteId;

	private String active;

	private BigDecimal cmmview;

	private BigDecimal depth;

	private BigDecimal easting;

	private BigDecimal easting1;

	private String environment;

	@Column(name="hs_name")
	private String hsName;

	private BigDecimal latitude;

	private BigDecimal longitude;

	@Column(name="ms_dx_name")
	private String msDxName;

	@Column(name="ms_id")
	private BigDecimal msId;

	@Column(name="ms_name")
	private String msName;

	@Column(name="ms_ts_name")
	private String msTsName;

	@Column(name="mt_name")
	private String mtName;

	@Column(name="mw_id")
	private BigDecimal mwId;

	@Column(name="mw_name")
	private String mwName;

	@Column(name="mw_ts_name")
	private String mwTsName;

	private BigDecimal northing;

	private BigDecimal northing1;

	private String show;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="station_id")
	private BigDecimal stationId;

	@Column(name="sz_id")
	private String szId;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="wcz_code")
	private BigDecimal wczCode;

	public Mstation() {
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

	public BigDecimal getCmmview() {
		return this.cmmview;
	}

	public void setCmmview(BigDecimal cmmview) {
		this.cmmview = cmmview;
	}

	public BigDecimal getDepth() {
		return this.depth;
	}

	public void setDepth(BigDecimal depth) {
		this.depth = depth;
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

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getHsName() {
		return this.hsName;
	}

	public void setHsName(String hsName) {
		this.hsName = hsName;
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

	public String getMsDxName() {
		return this.msDxName;
	}

	public void setMsDxName(String msDxName) {
		this.msDxName = msDxName;
	}

	public BigDecimal getMsId() {
		return this.msId;
	}

	public void setMsId(BigDecimal msId) {
		this.msId = msId;
	}

	public String getMsName() {
		return this.msName;
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public String getMsTsName() {
		return this.msTsName;
	}

	public void setMsTsName(String msTsName) {
		this.msTsName = msTsName;
	}

	public String getMtName() {
		return this.mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public BigDecimal getMwId() {
		return this.mwId;
	}

	public void setMwId(BigDecimal mwId) {
		this.mwId = mwId;
	}

	public String getMwName() {
		return this.mwName;
	}

	public void setMwName(String mwName) {
		this.mwName = mwName;
	}

	public String getMwTsName() {
		return this.mwTsName;
	}

	public void setMwTsName(String mwTsName) {
		this.mwTsName = mwTsName;
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

	public BigDecimal getWczCode() {
		return this.wczCode;
	}

	public void setWczCode(BigDecimal wczCode) {
		this.wczCode = wczCode;
	}

}