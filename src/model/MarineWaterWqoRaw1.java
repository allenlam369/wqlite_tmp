package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the marine_water_wqo_raw1 database table.
 * 
 */
@Entity
@Table(name="marine_water_wqo_raw1")
@NamedQuery(name="MarineWaterWqoRaw1.findAll", query="SELECT m FROM MarineWaterWqoRaw1 m")
public class MarineWaterWqoRaw1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MarineWaterWqoRaw1PK id;

	private BigDecimal doa;

	private BigDecimal dob;

	private BigDecimal doc;

	private BigDecimal dom;

	private BigDecimal dos;

	private double ecoli;

	@Column(name="max_ecoli_agm")
	private BigDecimal maxEcoliAgm;

	@Column(name="max_nh3_aam")
	private BigDecimal maxNh3Aam;

	@Column(name="max_tin_aam")
	private BigDecimal maxTinAam;

	@Column(name="meet_doa")
	private String meetDoa;

	@Column(name="meet_dob")
	private String meetDob;

	@Column(name="meet_doc")
	private String meetDoc;

	@Column(name="meet_dom")
	private String meetDom;

	@Column(name="meet_dos")
	private String meetDos;

	@Column(name="min_doa")
	private BigDecimal minDoa;

	@Column(name="min_doa_pc")
	private BigDecimal minDoaPc;

	@Column(name="min_dob")
	private BigDecimal minDob;

	@Column(name="min_dob_pc")
	private BigDecimal minDobPc;

	@Column(name="min_doc")
	private BigDecimal minDoc;

	@Column(name="min_doc_pc")
	private BigDecimal minDocPc;

	@Column(name="min_dom")
	private BigDecimal minDom;

	@Column(name="min_dom_pc")
	private BigDecimal minDomPc;

	@Column(name="min_dos")
	private BigDecimal minDos;

	@Column(name="min_dos_pc")
	private BigDecimal minDosPc;

	private BigDecimal nh3;

	@Column(name="sample_no")
	private BigDecimal sampleNo;

	private BigDecimal stime;

	private String subzone;

	private BigDecimal tin;

	private String wcz;

	@Column(name="zone_")
	private String zone;

	public MarineWaterWqoRaw1() {
	}

	public MarineWaterWqoRaw1PK getId() {
		return this.id;
	}

	public void setId(MarineWaterWqoRaw1PK id) {
		this.id = id;
	}

	public BigDecimal getDoa() {
		return this.doa;
	}

	public void setDoa(BigDecimal doa) {
		this.doa = doa;
	}

	public BigDecimal getDob() {
		return this.dob;
	}

	public void setDob(BigDecimal dob) {
		this.dob = dob;
	}

	public BigDecimal getDoc() {
		return this.doc;
	}

	public void setDoc(BigDecimal doc) {
		this.doc = doc;
	}

	public BigDecimal getDom() {
		return this.dom;
	}

	public void setDom(BigDecimal dom) {
		this.dom = dom;
	}

	public BigDecimal getDos() {
		return this.dos;
	}

	public void setDos(BigDecimal dos) {
		this.dos = dos;
	}

	public double getEcoli() {
		return this.ecoli;
	}

	public void setEcoli(double ecoli) {
		this.ecoli = ecoli;
	}

	public BigDecimal getMaxEcoliAgm() {
		return this.maxEcoliAgm;
	}

	public void setMaxEcoliAgm(BigDecimal maxEcoliAgm) {
		this.maxEcoliAgm = maxEcoliAgm;
	}

	public BigDecimal getMaxNh3Aam() {
		return this.maxNh3Aam;
	}

	public void setMaxNh3Aam(BigDecimal maxNh3Aam) {
		this.maxNh3Aam = maxNh3Aam;
	}

	public BigDecimal getMaxTinAam() {
		return this.maxTinAam;
	}

	public void setMaxTinAam(BigDecimal maxTinAam) {
		this.maxTinAam = maxTinAam;
	}

	public String getMeetDoa() {
		return this.meetDoa;
	}

	public void setMeetDoa(String meetDoa) {
		this.meetDoa = meetDoa;
	}

	public String getMeetDob() {
		return this.meetDob;
	}

	public void setMeetDob(String meetDob) {
		this.meetDob = meetDob;
	}

	public String getMeetDoc() {
		return this.meetDoc;
	}

	public void setMeetDoc(String meetDoc) {
		this.meetDoc = meetDoc;
	}

	public String getMeetDom() {
		return this.meetDom;
	}

	public void setMeetDom(String meetDom) {
		this.meetDom = meetDom;
	}

	public String getMeetDos() {
		return this.meetDos;
	}

	public void setMeetDos(String meetDos) {
		this.meetDos = meetDos;
	}

	public BigDecimal getMinDoa() {
		return this.minDoa;
	}

	public void setMinDoa(BigDecimal minDoa) {
		this.minDoa = minDoa;
	}

	public BigDecimal getMinDoaPc() {
		return this.minDoaPc;
	}

	public void setMinDoaPc(BigDecimal minDoaPc) {
		this.minDoaPc = minDoaPc;
	}

	public BigDecimal getMinDob() {
		return this.minDob;
	}

	public void setMinDob(BigDecimal minDob) {
		this.minDob = minDob;
	}

	public BigDecimal getMinDobPc() {
		return this.minDobPc;
	}

	public void setMinDobPc(BigDecimal minDobPc) {
		this.minDobPc = minDobPc;
	}

	public BigDecimal getMinDoc() {
		return this.minDoc;
	}

	public void setMinDoc(BigDecimal minDoc) {
		this.minDoc = minDoc;
	}

	public BigDecimal getMinDocPc() {
		return this.minDocPc;
	}

	public void setMinDocPc(BigDecimal minDocPc) {
		this.minDocPc = minDocPc;
	}

	public BigDecimal getMinDom() {
		return this.minDom;
	}

	public void setMinDom(BigDecimal minDom) {
		this.minDom = minDom;
	}

	public BigDecimal getMinDomPc() {
		return this.minDomPc;
	}

	public void setMinDomPc(BigDecimal minDomPc) {
		this.minDomPc = minDomPc;
	}

	public BigDecimal getMinDos() {
		return this.minDos;
	}

	public void setMinDos(BigDecimal minDos) {
		this.minDos = minDos;
	}

	public BigDecimal getMinDosPc() {
		return this.minDosPc;
	}

	public void setMinDosPc(BigDecimal minDosPc) {
		this.minDosPc = minDosPc;
	}

	public BigDecimal getNh3() {
		return this.nh3;
	}

	public void setNh3(BigDecimal nh3) {
		this.nh3 = nh3;
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

	public BigDecimal getTin() {
		return this.tin;
	}

	public void setTin(BigDecimal tin) {
		this.tin = tin;
	}

	public String getWcz() {
		return this.wcz;
	}

	public void setWcz(String wcz) {
		this.wcz = wcz;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}