package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the river_water1 database table.
 * 
 */
@Entity
@Table(name="river_water1")
@NamedQuery(name="RiverWater1.findAll", query="SELECT r FROM RiverWater1 r")
public class RiverWater1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RiverWater1PK id;

	private BigDecimal ag;

	private BigDecimal al;

	private BigDecimal arsenic;

	private BigDecimal b;

	private BigDecimal ba;

	private BigDecimal be;

	private BigDecimal bod5;

	@Column(name="bod5_pt")
	private BigDecimal bod5Pt;

	private BigDecimal cd;

	private BigDecimal chl;

	private BigDecimal cl;

	private BigDecimal cod;

	private String color;

	private BigDecimal cond;

	private BigDecimal cr;

	private BigDecimal cu;

	private BigDecimal depth;

	private BigDecimal deterg;

	private BigDecimal do_;

	private BigDecimal dos;

	@Column(name="dos_pt")
	private BigDecimal dosPt;

	private BigDecimal ec;

	private BigDecimal fc;

	private BigDecimal fe;

	private BigDecimal fl;

	private BigDecimal flow;

	private BigDecimal h2s;

	private BigDecimal hg;

	@Column(name="l_ag")
	private String lAg;

	@Column(name="l_al")
	private String lAl;

	@Column(name="l_arsenic")
	private String lArsenic;

	@Column(name="l_b")
	private String lB;

	@Column(name="l_ba")
	private String lBa;

	@Column(name="l_be")
	private String lBe;

	@Column(name="l_bod5")
	private String lBod5;

	@Column(name="l_cd")
	private String lCd;

	@Column(name="l_chl")
	private String lChl;

	@Column(name="l_cl")
	private String lCl;

	@Column(name="l_cod")
	private String lCod;

	@Column(name="l_cond")
	private String lCond;

	@Column(name="l_cr")
	private String lCr;

	@Column(name="l_cu")
	private String lCu;

	@Column(name="l_deterg")
	private String lDeterg;

	@Column(name="l_do")
	private String lDo;

	@Column(name="l_dos")
	private String lDos;

	@Column(name="l_ec")
	private String lEc;

	@Column(name="l_fc")
	private String lFc;

	@Column(name="l_fe")
	private String lFe;

	@Column(name="l_fl")
	private String lFl;

	@Column(name="l_h2s")
	private String lH2s;

	@Column(name="l_hg")
	private String lHg;

	@Column(name="l_mn")
	private String lMn;

	@Column(name="l_mo")
	private String lMo;

	@Column(name="l_nh3")
	private String lNh3;

	@Column(name="l_nh4")
	private String lNh4;

	@Column(name="l_ni")
	private String lNi;

	@Column(name="l_no2")
	private String lNo2;

	@Column(name="l_no3")
	private String lNo3;

	@Column(name="l_oil")
	private String lOil;

	@Column(name="l_pb")
	private String lPb;

	@Column(name="l_ph")
	private String lPh;

	@Column(name="l_pheo")
	private String lPheo;

	@Column(name="l_po4")
	private String lPo4;

	@Column(name="l_sal")
	private String lSal;

	@Column(name="l_sb")
	private String lSb;

	@Column(name="l_sil")
	private String lSil;

	@Column(name="l_ss")
	private String lSs;

	@Column(name="l_ssp")
	private String lSsp;

	@Column(name="l_sulp")
	private String lSulp;

	@Column(name="l_tcyn")
	private String lTcyn;

	@Column(name="l_tkns")
	private String lTkns;

	@Column(name="l_tknsp")
	private String lTknsp;

	@Column(name="l_tl")
	private String lTl;

	@Column(name="l_toc")
	private String lToc;

	@Column(name="l_tps")
	private String lTps;

	@Column(name="l_tpsp")
	private String lTpsp;

	@Column(name="l_ts")
	private String lTs;

	@Column(name="l_turb")
	private String lTurb;

	@Column(name="l_tvs")
	private String lTvs;

	@Column(name="l_v")
	private String lV;

	@Column(name="l_zn")
	private String lZn;

	private BigDecimal mn;

	private BigDecimal mo;

	private BigDecimal nh3;

	private BigDecimal nh4;

	@Column(name="nh4_pt")
	private BigDecimal nh4Pt;

	private BigDecimal ni;

	private BigDecimal no2;

	private BigDecimal no3;

	private BigDecimal oil;

	private BigDecimal pb;

	private BigDecimal ph;

	private BigDecimal pheo;

	private BigDecimal po4;

	private String rainfall;

	private String remark;

	private String river;

	private BigDecimal sal;

	@Column(name="sample_no")
	private Integer sampleNo;

	private BigDecimal sb;

	private BigDecimal sil;

	private String smell;

	private BigDecimal ss;

	private BigDecimal ssp;

	private BigDecimal stime;

	private String subzone;

	private BigDecimal sulp;

	private BigDecimal tcyn;

	private BigDecimal temper;

	private String tide;

	private BigDecimal tin;

	private BigDecimal tkns;

	private BigDecimal tknsp;

	private BigDecimal tl;

	private BigDecimal tn;

	private BigDecimal toc;

	private BigDecimal tps;

	private BigDecimal tpsp;

	private BigDecimal ts;

	private BigDecimal turb;

	private BigDecimal tvs;

	private BigDecimal v;

	private BigDecimal vel;

	@Column(name="view_no")
	private BigDecimal viewNo;

	private String wcz;

	private String weather;

	private BigDecimal width;

	@Column(name="wqi_grade")
	private String wqiGrade;

	@Column(name="wqi_pt")
	private BigDecimal wqiPt;

	private BigDecimal zn;

	private String zone;

	public RiverWater1() {
	}

	public RiverWater1PK getId() {
		return this.id;
	}

	public void setId(RiverWater1PK id) {
		this.id = id;
	}

	public BigDecimal getAg() {
		return this.ag;
	}

	public void setAg(BigDecimal ag) {
		this.ag = ag;
	}

	public BigDecimal getAl() {
		return this.al;
	}

	public void setAl(BigDecimal al) {
		this.al = al;
	}

	public BigDecimal getArsenic() {
		return this.arsenic;
	}

	public void setArsenic(BigDecimal arsenic) {
		this.arsenic = arsenic;
	}

	public BigDecimal getB() {
		return this.b;
	}

	public void setB(BigDecimal b) {
		this.b = b;
	}

	public BigDecimal getBa() {
		return this.ba;
	}

	public void setBa(BigDecimal ba) {
		this.ba = ba;
	}

	public BigDecimal getBe() {
		return this.be;
	}

	public void setBe(BigDecimal be) {
		this.be = be;
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

	public BigDecimal getCd() {
		return this.cd;
	}

	public void setCd(BigDecimal cd) {
		this.cd = cd;
	}

	public BigDecimal getChl() {
		return this.chl;
	}

	public void setChl(BigDecimal chl) {
		this.chl = chl;
	}

	public BigDecimal getCl() {
		return this.cl;
	}

	public void setCl(BigDecimal cl) {
		this.cl = cl;
	}

	public BigDecimal getCod() {
		return this.cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getCond() {
		return this.cond;
	}

	public void setCond(BigDecimal cond) {
		this.cond = cond;
	}

	public BigDecimal getCr() {
		return this.cr;
	}

	public void setCr(BigDecimal cr) {
		this.cr = cr;
	}

	public BigDecimal getCu() {
		return this.cu;
	}

	public void setCu(BigDecimal cu) {
		this.cu = cu;
	}

	public BigDecimal getDepth() {
		return this.depth;
	}

	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}

	public BigDecimal getDeterg() {
		return this.deterg;
	}

	public void setDeterg(BigDecimal deterg) {
		this.deterg = deterg;
	}

	public BigDecimal getDo_() {
		return this.do_;
	}

	public void setDo_(BigDecimal do_) {
		this.do_ = do_;
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

	public BigDecimal getEc() {
		return this.ec;
	}

	public void setEc(BigDecimal ec) {
		this.ec = ec;
	}

	public BigDecimal getFc() {
		return this.fc;
	}

	public void setFc(BigDecimal fc) {
		this.fc = fc;
	}

	public BigDecimal getFe() {
		return this.fe;
	}

	public void setFe(BigDecimal fe) {
		this.fe = fe;
	}

	public BigDecimal getFl() {
		return this.fl;
	}

	public void setFl(BigDecimal fl) {
		this.fl = fl;
	}

	public BigDecimal getFlow() {
		return this.flow;
	}

	public void setFlow(BigDecimal flow) {
		this.flow = flow;
	}

	public BigDecimal getH2s() {
		return this.h2s;
	}

	public void setH2s(BigDecimal h2s) {
		this.h2s = h2s;
	}

	public BigDecimal getHg() {
		return this.hg;
	}

	public void setHg(BigDecimal hg) {
		this.hg = hg;
	}

	public String getLAg() {
		return this.lAg;
	}

	public void setLAg(String lAg) {
		this.lAg = lAg;
	}

	public String getLAl() {
		return this.lAl;
	}

	public void setLAl(String lAl) {
		this.lAl = lAl;
	}

	public String getLArsenic() {
		return this.lArsenic;
	}

	public void setLArsenic(String lArsenic) {
		this.lArsenic = lArsenic;
	}

	public String getLB() {
		return this.lB;
	}

	public void setLB(String lB) {
		this.lB = lB;
	}

	public String getLBa() {
		return this.lBa;
	}

	public void setLBa(String lBa) {
		this.lBa = lBa;
	}

	public String getLBe() {
		return this.lBe;
	}

	public void setLBe(String lBe) {
		this.lBe = lBe;
	}

	public String getLBod5() {
		return this.lBod5;
	}

	public void setLBod5(String lBod5) {
		this.lBod5 = lBod5;
	}

	public String getLCd() {
		return this.lCd;
	}

	public void setLCd(String lCd) {
		this.lCd = lCd;
	}

	public String getLChl() {
		return this.lChl;
	}

	public void setLChl(String lChl) {
		this.lChl = lChl;
	}

	public String getLCl() {
		return this.lCl;
	}

	public void setLCl(String lCl) {
		this.lCl = lCl;
	}

	public String getLCod() {
		return this.lCod;
	}

	public void setLCod(String lCod) {
		this.lCod = lCod;
	}

	public String getLCond() {
		return this.lCond;
	}

	public void setLCond(String lCond) {
		this.lCond = lCond;
	}

	public String getLCr() {
		return this.lCr;
	}

	public void setLCr(String lCr) {
		this.lCr = lCr;
	}

	public String getLCu() {
		return this.lCu;
	}

	public void setLCu(String lCu) {
		this.lCu = lCu;
	}

	public String getLDeterg() {
		return this.lDeterg;
	}

	public void setLDeterg(String lDeterg) {
		this.lDeterg = lDeterg;
	}

	public String getLDo() {
		return this.lDo;
	}

	public void setLDo(String lDo) {
		this.lDo = lDo;
	}

	public String getLDos() {
		return this.lDos;
	}

	public void setLDos(String lDos) {
		this.lDos = lDos;
	}

	public String getLEc() {
		return this.lEc;
	}

	public void setLEc(String lEc) {
		this.lEc = lEc;
	}

	public String getLFc() {
		return this.lFc;
	}

	public void setLFc(String lFc) {
		this.lFc = lFc;
	}

	public String getLFe() {
		return this.lFe;
	}

	public void setLFe(String lFe) {
		this.lFe = lFe;
	}

	public String getLFl() {
		return this.lFl;
	}

	public void setLFl(String lFl) {
		this.lFl = lFl;
	}

	public String getLH2s() {
		return this.lH2s;
	}

	public void setLH2s(String lH2s) {
		this.lH2s = lH2s;
	}

	public String getLHg() {
		return this.lHg;
	}

	public void setLHg(String lHg) {
		this.lHg = lHg;
	}

	public String getLMn() {
		return this.lMn;
	}

	public void setLMn(String lMn) {
		this.lMn = lMn;
	}

	public String getLMo() {
		return this.lMo;
	}

	public void setLMo(String lMo) {
		this.lMo = lMo;
	}

	public String getLNh3() {
		return this.lNh3;
	}

	public void setLNh3(String lNh3) {
		this.lNh3 = lNh3;
	}

	public String getLNh4() {
		return this.lNh4;
	}

	public void setLNh4(String lNh4) {
		this.lNh4 = lNh4;
	}

	public String getLNi() {
		return this.lNi;
	}

	public void setLNi(String lNi) {
		this.lNi = lNi;
	}

	public String getLNo2() {
		return this.lNo2;
	}

	public void setLNo2(String lNo2) {
		this.lNo2 = lNo2;
	}

	public String getLNo3() {
		return this.lNo3;
	}

	public void setLNo3(String lNo3) {
		this.lNo3 = lNo3;
	}

	public String getLOil() {
		return this.lOil;
	}

	public void setLOil(String lOil) {
		this.lOil = lOil;
	}

	public String getLPb() {
		return this.lPb;
	}

	public void setLPb(String lPb) {
		this.lPb = lPb;
	}

	public String getLPh() {
		return this.lPh;
	}

	public void setLPh(String lPh) {
		this.lPh = lPh;
	}

	public String getLPheo() {
		return this.lPheo;
	}

	public void setLPheo(String lPheo) {
		this.lPheo = lPheo;
	}

	public String getLPo4() {
		return this.lPo4;
	}

	public void setLPo4(String lPo4) {
		this.lPo4 = lPo4;
	}

	public String getLSal() {
		return this.lSal;
	}

	public void setLSal(String lSal) {
		this.lSal = lSal;
	}

	public String getLSb() {
		return this.lSb;
	}

	public void setLSb(String lSb) {
		this.lSb = lSb;
	}

	public String getLSil() {
		return this.lSil;
	}

	public void setLSil(String lSil) {
		this.lSil = lSil;
	}

	public String getLSs() {
		return this.lSs;
	}

	public void setLSs(String lSs) {
		this.lSs = lSs;
	}

	public String getLSsp() {
		return this.lSsp;
	}

	public void setLSsp(String lSsp) {
		this.lSsp = lSsp;
	}

	public String getLSulp() {
		return this.lSulp;
	}

	public void setLSulp(String lSulp) {
		this.lSulp = lSulp;
	}

	public String getLTcyn() {
		return this.lTcyn;
	}

	public void setLTcyn(String lTcyn) {
		this.lTcyn = lTcyn;
	}

	public String getLTkns() {
		return this.lTkns;
	}

	public void setLTkns(String lTkns) {
		this.lTkns = lTkns;
	}

	public String getLTknsp() {
		return this.lTknsp;
	}

	public void setLTknsp(String lTknsp) {
		this.lTknsp = lTknsp;
	}

	public String getLTl() {
		return this.lTl;
	}

	public void setLTl(String lTl) {
		this.lTl = lTl;
	}

	public String getLToc() {
		return this.lToc;
	}

	public void setLToc(String lToc) {
		this.lToc = lToc;
	}

	public String getLTps() {
		return this.lTps;
	}

	public void setLTps(String lTps) {
		this.lTps = lTps;
	}

	public String getLTpsp() {
		return this.lTpsp;
	}

	public void setLTpsp(String lTpsp) {
		this.lTpsp = lTpsp;
	}

	public String getLTs() {
		return this.lTs;
	}

	public void setLTs(String lTs) {
		this.lTs = lTs;
	}

	public String getLTurb() {
		return this.lTurb;
	}

	public void setLTurb(String lTurb) {
		this.lTurb = lTurb;
	}

	public String getLTvs() {
		return this.lTvs;
	}

	public void setLTvs(String lTvs) {
		this.lTvs = lTvs;
	}

	public String getLV() {
		return this.lV;
	}

	public void setLV(String lV) {
		this.lV = lV;
	}

	public String getLZn() {
		return this.lZn;
	}

	public void setLZn(String lZn) {
		this.lZn = lZn;
	}

	public BigDecimal getMn() {
		return this.mn;
	}

	public void setMn(BigDecimal mn) {
		this.mn = mn;
	}

	public BigDecimal getMo() {
		return this.mo;
	}

	public void setMo(BigDecimal mo) {
		this.mo = mo;
	}

	public BigDecimal getNh3() {
		return this.nh3;
	}

	public void setNh3(BigDecimal nh3) {
		this.nh3 = nh3;
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

	public BigDecimal getNi() {
		return this.ni;
	}

	public void setNi(BigDecimal ni) {
		this.ni = ni;
	}

	public BigDecimal getNo2() {
		return this.no2;
	}

	public void setNo2(BigDecimal no2) {
		this.no2 = no2;
	}

	public BigDecimal getNo3() {
		return this.no3;
	}

	public void setNo3(BigDecimal no3) {
		this.no3 = no3;
	}

	public BigDecimal getOil() {
		return this.oil;
	}

	public void setOil(BigDecimal oil) {
		this.oil = oil;
	}

	public BigDecimal getPb() {
		return this.pb;
	}

	public void setPb(BigDecimal pb) {
		this.pb = pb;
	}

	public BigDecimal getPh() {
		return this.ph;
	}

	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	public BigDecimal getPheo() {
		return this.pheo;
	}

	public void setPheo(BigDecimal pheo) {
		this.pheo = pheo;
	}

	public BigDecimal getPo4() {
		return this.po4;
	}

	public void setPo4(BigDecimal po4) {
		this.po4 = po4;
	}

	public String getRainfall() {
		return this.rainfall;
	}

	public void setRainfall(String rainfall) {
		this.rainfall = rainfall;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRiver() {
		return this.river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public Integer getSampleNo() {
		return this.sampleNo;
	}

	public void setSampleNo(Integer sampleNo) {
		this.sampleNo = sampleNo;
	}

	public BigDecimal getSb() {
		return this.sb;
	}

	public void setSb(BigDecimal sb) {
		this.sb = sb;
	}

	public BigDecimal getSil() {
		return this.sil;
	}

	public void setSil(BigDecimal sil) {
		this.sil = sil;
	}

	public String getSmell() {
		return this.smell;
	}

	public void setSmell(String smell) {
		this.smell = smell;
	}

	public BigDecimal getSs() {
		return this.ss;
	}

	public void setSs(BigDecimal ss) {
		this.ss = ss;
	}

	public BigDecimal getSsp() {
		return this.ssp;
	}

	public void setSsp(BigDecimal ssp) {
		this.ssp = ssp;
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

	public BigDecimal getSulp() {
		return this.sulp;
	}

	public void setSulp(BigDecimal sulp) {
		this.sulp = sulp;
	}

	public BigDecimal getTcyn() {
		return this.tcyn;
	}

	public void setTcyn(BigDecimal tcyn) {
		this.tcyn = tcyn;
	}

	public BigDecimal getTemper() {
		return this.temper;
	}

	public void setTemper(BigDecimal temper) {
		this.temper = temper;
	}

	public String getTide() {
		return this.tide;
	}

	public void setTide(String tide) {
		this.tide = tide;
	}

	public BigDecimal getTin() {
		return this.tin;
	}

	public void setTin(BigDecimal tin) {
		this.tin = tin;
	}

	public BigDecimal getTkns() {
		return this.tkns;
	}

	public void setTkns(BigDecimal tkns) {
		this.tkns = tkns;
	}

	public BigDecimal getTknsp() {
		return this.tknsp;
	}

	public void setTknsp(BigDecimal tknsp) {
		this.tknsp = tknsp;
	}

	public BigDecimal getTl() {
		return this.tl;
	}

	public void setTl(BigDecimal tl) {
		this.tl = tl;
	}

	public BigDecimal getTn() {
		return this.tn;
	}

	public void setTn(BigDecimal tn) {
		this.tn = tn;
	}

	public BigDecimal getToc() {
		return this.toc;
	}

	public void setToc(BigDecimal toc) {
		this.toc = toc;
	}

	public BigDecimal getTps() {
		return this.tps;
	}

	public void setTps(BigDecimal tps) {
		this.tps = tps;
	}

	public BigDecimal getTpsp() {
		return this.tpsp;
	}

	public void setTpsp(BigDecimal tpsp) {
		this.tpsp = tpsp;
	}

	public BigDecimal getTs() {
		return this.ts;
	}

	public void setTs(BigDecimal ts) {
		this.ts = ts;
	}

	public BigDecimal getTurb() {
		return this.turb;
	}

	public void setTurb(BigDecimal turb) {
		this.turb = turb;
	}

	public BigDecimal getTvs() {
		return this.tvs;
	}

	public void setTvs(BigDecimal tvs) {
		this.tvs = tvs;
	}

	public BigDecimal getV() {
		return this.v;
	}

	public void setV(BigDecimal v) {
		this.v = v;
	}

	public BigDecimal getVel() {
		return this.vel;
	}

	public void setVel(BigDecimal vel) {
		this.vel = vel;
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

	public String getWeather() {
		return this.weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public BigDecimal getWidth() {
		return this.width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
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

	public BigDecimal getZn() {
		return this.zn;
	}

	public void setZn(BigDecimal zn) {
		this.zn = zn;
	}

	public String getZone() {
		return this.zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

}