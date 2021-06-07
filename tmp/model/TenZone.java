package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ten_zone database table.
 * 
 */
@Entity
@Table(name="ten_zone")
@NamedQuery(name="TenZone.findAll", query="SELECT t FROM TenZone t")
public class TenZone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="zone_id")
	private String zoneId;

	@Column(name="chinese_name")
	private String chineseName;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="zone_name")
	private String zoneName;

	@Column(name="zone_order")
	private BigDecimal zoneOrder;

	public TenZone() {
	}

	public String getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
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

	public String getZoneName() {
		return this.zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public BigDecimal getZoneOrder() {
		return this.zoneOrder;
	}

	public void setZoneOrder(BigDecimal zoneOrder) {
		this.zoneOrder = zoneOrder;
	}

}