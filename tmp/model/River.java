package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the river database table.
 * 
 */
@Entity
@NamedQuery(name="River.findAll", query="SELECT r FROM River r")
public class River implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="r_id")
	private String rId;

	@Column(name="chinese_name")
	private String chineseName;

	@Column(name="river_id")
	private BigDecimal riverId;

	@Column(name="river_name")
	private String riverName;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="zone_id")
	private String zoneId;

	public River() {
	}

	public String getRId() {
		return this.rId;
	}

	public void setRId(String rId) {
		this.rId = rId;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public BigDecimal getRiverId() {
		return this.riverId;
	}

	public void setRiverId(BigDecimal riverId) {
		this.riverId = riverId;
	}

	public String getRiverName() {
		return this.riverName;
	}

	public void setRiverName(String riverName) {
		this.riverName = riverName;
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

	public String getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

}