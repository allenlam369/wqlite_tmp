package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the wpco_wcz database table.
 * 
 */
@Entity
@Table(name="wpco_wcz")
@NamedQuery(name="WpcoWcz.findAll", query="SELECT w FROM WpcoWcz w")
public class WpcoWcz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="wcz_id")
	private String wczId;

	@Column(name="chinese_name")
	private String chineseName;

	private Timestamp fad;

	@Column(name="valid_code")
	private BigDecimal validCode;

	@Column(name="valid_date")
	private Timestamp validDate;

	@Column(name="valid_user")
	private String validUser;

	@Column(name="wcz_abbr")
	private String wczAbbr;

	@Column(name="wcz_code")
	private BigDecimal wczCode;

	@Column(name="wcz_label")
	private String wczLabel;

	@Column(name="wcz_name")
	private String wczName;

	@Column(name="zone_id")
	private String zoneId;

	//bi-directional many-to-one association to WpcoSz
	@OneToMany(mappedBy="wpcoWcz")
	private List<WpcoSz> wpcoSzs;

	public WpcoWcz() {
	}

	public String getWczId() {
		return this.wczId;
	}

	public void setWczId(String wczId) {
		this.wczId = wczId;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public Timestamp getFad() {
		return this.fad;
	}

	public void setFad(Timestamp fad) {
		this.fad = fad;
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

	public String getWczAbbr() {
		return this.wczAbbr;
	}

	public void setWczAbbr(String wczAbbr) {
		this.wczAbbr = wczAbbr;
	}

	public BigDecimal getWczCode() {
		return this.wczCode;
	}

	public void setWczCode(BigDecimal wczCode) {
		this.wczCode = wczCode;
	}

	public String getWczLabel() {
		return this.wczLabel;
	}

	public void setWczLabel(String wczLabel) {
		this.wczLabel = wczLabel;
	}

	public String getWczName() {
		return this.wczName;
	}

	public void setWczName(String wczName) {
		this.wczName = wczName;
	}

	public String getZoneId() {
		return this.zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public List<WpcoSz> getWpcoSzs() {
		return this.wpcoSzs;
	}

	public void setWpcoSzs(List<WpcoSz> wpcoSzs) {
		this.wpcoSzs = wpcoSzs;
	}

	public WpcoSz addWpcoSz(WpcoSz wpcoSz) {
		getWpcoSzs().add(wpcoSz);
		wpcoSz.setWpcoWcz(this);

		return wpcoSz;
	}

	public WpcoSz removeWpcoSz(WpcoSz wpcoSz) {
		getWpcoSzs().remove(wpcoSz);
		wpcoSz.setWpcoWcz(null);

		return wpcoSz;
	}

}