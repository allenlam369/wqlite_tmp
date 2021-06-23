package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the river_water_wqi1 database table.
 * 
 */
@Entity
@Table(name="river_water_wqi1")
@NamedQuery(name="RiverWaterWqi1.findAll", query="SELECT r FROM RiverWaterWqi1 r")
public class RiverWaterWqi1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RiverWaterWqi1PK id;

	private BigDecimal bod5;

	@Column(name="bod5_pt")
	private BigDecimal bod5Pt;

	private BigDecimal dos;

	@Column(name="dos_pt")
	private BigDecimal dosPt;

	@Column(name="l_bod5")
	private String lBod5;

	@Column(name="l_dos")
	private String lDos;

	@Column(name="l_nh4")
	private String lNh4;

	private BigDecimal nh4;

	@Column(name="nh4_pt")
	private BigDecimal nh4Pt;

	private String river;

	@Column(name="sample_no")
	private BigDecimal sampleNo;

	private BigDecimal stime;

	private String subzone;

	@Column(name="view_no")
	private BigDecimal viewNo;

	private String wcz;

	@Column(name="wqi_grade")
	private String wqiGrade;

	@Column(name="wqi_pt")
	private BigDecimal wqiPt;

	private String zone;

	public RiverWaterWqi1() {
	}

	public RiverWaterWqi1PK getId() {
		return this.id;
	}

	public void setId(RiverWaterWqi1PK id) {
		this.id = id;
	}

	public BigDecimal getBod5() {
		return this.bod5;
	}

	public void setBod5(BigDecimal bod5) {
		this.bod5 = bod5;
	}

	public BigDecimal getBod5Pt() {
		return this.bod5Pt;
	}

	public void setBod5Pt(BigDecimal bod5Pt) {
		this.bod5Pt = bod5Pt;
	}

	public BigDecimal getDos() {
		return this.dos;
	}

	public void setDos(BigDecimal dos) {
		this.dos = dos;
	}

	public BigDecimal getDosPt() {
		return this.dosPt;
	}

	public void setDosPt(BigDecimal dosPt) {
		this.dosPt = dosPt;
	}

	public String getLBod5() {
		return this.lBod5;
	}

	public void setLBod5(String lBod5) {
		this.lBod5 = lBod5;
	}

	public String getLDos() {
		return this.lDos;
	}

	public void setLDos(String lDos) {
		this.lDos = lDos;
	}

	public String getLNh4() {
		return this.lNh4;
	}

	public void setLNh4(String lNh4) {
		this.lNh4 = lNh4;
	}

	public BigDecimal getNh4() {
		return this.nh4;
	}

	public void setNh4(BigDecimal nh4) {
		this.nh4 = nh4;
	}

	public BigDecimal getNh4Pt() {
		return this.nh4Pt;
	}

	public void setNh4Pt(BigDecimal nh4Pt) {
		this.nh4Pt = nh4Pt;
	}

	public String getRiver() {
		return this.river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public BigDecimal getSampleNo() {
		return this.sampleNo;
	}

	public void setSampleNo(BigDecimal sampleNo) {
		this.sampleNo = sampleNo;
	}

	public BigDecimal getStime() {
		return this.stime;
	}

	public void setStime(BigDecimal stime) {
		this.stime = stime;
	}

	public String getSubzone() {
		return this.subzone;
	}

	public void setSubzone(String subzone) {
		this.subzone = subzone;
	}

	public BigDecimal getViewNo() {
		return this.viewNo;
	}

	public void setViewNo(BigDecimal viewNo) {
		this.viewNo = viewNo;
	}

	public String getWcz() {
		return this.wcz;
	}

	public void setWcz(String wcz) {
		this.wcz = wcz;
	}

	public String getWqiGrade() {
		return this.wqiGrade;
	}

	public void setWqiGrade(String wqiGrade) {
		this.wqiGrade = wqiGrade;
	}

	public BigDecimal getWqiPt() {
		return this.wqiPt;
	}

	public void setWqiPt(BigDecimal wqiPt) {
		this.wqiPt = wqiPt;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}