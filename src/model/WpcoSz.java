package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the wpco_sz database table.
 * 
 */
@Entity
@Table(name="wpco_sz")
@NamedQuery(name="WpcoSz.findAll", query="SELECT w FROM WpcoSz w")
public class WpcoSz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sz_id")
	private String szId;

	@Column(name="chinese_name")
	private String chineseName;

	@Column(name="marine_inland")
	private String marineInland;

	@Column(name="sz_name")
	private String szName;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="wcsz_code")
	private BigDecimal wcszCode;

	@Column(name="wpco_subleg")
	private String wpcoSubleg;

	//bi-directional many-to-one association to WpcoWcz
	@ManyToOne
	@JoinColumn(name="wcz_id")
	private WpcoWcz wpcoWcz;

	public WpcoSz() {
	}

	public String getSzId() {
		return this.szId;
	}

	public void setSzId(String szId) {
		this.szId = szId;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getMarineInland() {
		return this.marineInland;
	}

	public void setMarineInland(String marineInland) {
		this.marineInland = marineInland;
	}

	public String getSzName() {
		return this.szName;
	}

	public void setSzName(String szName) {
		this.szName = szName;
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

	public String getWpcoSubleg() {
		return this.wpcoSubleg;
	}

	public void setWpcoSubleg(String wpcoSubleg) {
		this.wpcoSubleg = wpcoSubleg;
	}

	public WpcoWcz getWpcoWcz() {
		return this.wpcoWcz;
	}

	public void setWpcoWcz(WpcoWcz wpcoWcz) {
		this.wpcoWcz = wpcoWcz;
	}

}