package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the bm_visit_label_summary database table.
 * 
 */
@Entity
@Table(name="bm_visit_label_summary")
@NamedQuery(name="BmVisitLabelSummary.findAll", query="SELECT b FROM BmVisitLabelSummary b")
public class BmVisitLabelSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bmvisit_id")
	private String bmvisitId;

	@Column(name="abs_tide_height")
	private BigDecimal absTideHeight;

	@Column(name="adj_log_gm")
	private BigDecimal adjLogGm;

	@Column(name="adj_log_gm_fc")
	private BigDecimal adjLogGmFc;

	private String bather;

	@Column(name="bather_value")
	private BigDecimal batherValue;

	@Column(name="beach_code")
	private String beachCode;

	@Column(name="beach_group")
	private String beachGroup;

	@Column(name="beach_name")
	private String beachName;

	private String climate;

	@Column(name="climate_value")
	private BigDecimal climateValue;

	private String closed;

	private Timestamp dayappend;

	private Timestamp dayedit;

	private Timestamp dayupload;

	@Column(name="district_name")
	private String districtName;

	@Column(name="district_order")
	private String districtOrder;

	private BigDecimal do_;

	private BigDecimal dos;

	@Column(name="ec_f1")
	private BigDecimal ecF1;

	@Column(name="ec_f2")
	private BigDecimal ecF2;

	@Column(name="ec_f3")
	private BigDecimal ecF3;

	@Column(name="ec_f4")
	private BigDecimal ecF4;

	@Column(name="ec_f5")
	private BigDecimal ecF5;

	@Column(name="ec_l")
	private BigDecimal ecL;

	@Column(name="ec_m")
	private BigDecimal ecM;

	@Column(name="ec_o")
	private BigDecimal ecO;

	@Column(name="ec_r")
	private BigDecimal ecR;

	@Column(name="ec_s1")
	private BigDecimal ecS1;

	@Column(name="ec_s2")
	private BigDecimal ecS2;

	@Column(name="ec_s3")
	private BigDecimal ecS3;

	@Column(name="ec_s4")
	private BigDecimal ecS4;

	@Column(name="ec_s5")
	private BigDecimal ecS5;

	@Column(name="fc_f1")
	private BigDecimal fcF1;

	@Column(name="fc_f2")
	private BigDecimal fcF2;

	@Column(name="fc_f3")
	private BigDecimal fcF3;

	@Column(name="fc_f4")
	private BigDecimal fcF4;

	@Column(name="fc_f5")
	private BigDecimal fcF5;

	@Column(name="fc_l")
	private BigDecimal fcL;

	@Column(name="fc_m")
	private BigDecimal fcM;

	@Column(name="fc_o")
	private BigDecimal fcO;

	@Column(name="fc_r")
	private BigDecimal fcR;

	@Column(name="fc_s1")
	private BigDecimal fcS1;

	@Column(name="fc_s2")
	private BigDecimal fcS2;

	@Column(name="fc_s3")
	private BigDecimal fcS3;

	@Column(name="fc_s4")
	private BigDecimal fcS4;

	@Column(name="fc_s5")
	private BigDecimal fcS5;

	@Column(name="flow_f1")
	private String flowF1;

	@Column(name="flow_f2")
	private String flowF2;

	@Column(name="flow_f3")
	private String flowF3;

	@Column(name="flow_f4")
	private String flowF4;

	@Column(name="flow_f5")
	private String flowF5;

	@Column(name="flow_label_f1")
	private String flowLabelF1;

	@Column(name="flow_label_f2")
	private String flowLabelF2;

	@Column(name="flow_label_f3")
	private String flowLabelF3;

	@Column(name="flow_label_f4")
	private String flowLabelF4;

	@Column(name="flow_label_f5")
	private String flowLabelF5;

	@Column(name="flow_label_s1")
	private String flowLabelS1;

	@Column(name="flow_label_s2")
	private String flowLabelS2;

	@Column(name="flow_label_s3")
	private String flowLabelS3;

	@Column(name="flow_label_s4")
	private String flowLabelS4;

	@Column(name="flow_label_s5")
	private String flowLabelS5;

	@Column(name="flow_s1")
	private String flowS1;

	@Column(name="flow_s2")
	private String flowS2;

	@Column(name="flow_s3")
	private String flowS3;

	@Column(name="flow_s4")
	private String flowS4;

	@Column(name="flow_s5")
	private String flowS5;

	@Column(name="g_mean")
	private BigDecimal gMean;

	@Column(name="g_mean_fc")
	private BigDecimal gMeanFc;

	private BigDecimal grade;

	@Column(name="grade_change")
	private BigDecimal gradeChange;

	@Column(name="list_order")
	private String listOrder;

	@Column(name="log_g_mean")
	private BigDecimal logGMean;

	@Column(name="log_g_mean_fc")
	private BigDecimal logGMeanFc;

	private Timestamp mdate;

	@Column(name="move_avg")
	private BigDecimal moveAvg;

	@Column(name="move_avg_fc")
	private BigDecimal moveAvgFc;

	@Column(name="mrefuse_cleanlines_level")
	private BigDecimal mrefuseCleanlinesLevel;

	@Column(name="mth_g_mean")
	private BigDecimal mthGMean;

	@Column(name="mth_g_mean_fc")
	private BigDecimal mthGMeanFc;

	private BigDecimal ph;

	@Column(name="r_g_mean")
	private BigDecimal rGMean;

	@Column(name="r_g_mean_fc")
	private BigDecimal rGMeanFc;

	@Column(name="rain_station_code")
	private String rainStationCode;

	private BigDecimal rainfall;

	@Column(name="rainfall_last_12hr")
	private BigDecimal rainfallLast12hr;

	@Column(name="rainfall_last_24hr")
	private BigDecimal rainfallLast24hr;

	@Column(name="rainfall_last_72hr")
	private BigDecimal rainfallLast72hr;

	@Column(name="rainfall_max_3hr")
	private BigDecimal rainfallMax3hr;

	@Column(name="rainfall_max_time")
	private Timestamp rainfallMaxTime;

	private String remarks;

	@Column(name="risk_rain_last_12hr")
	private String riskRainLast12hr;

	@Column(name="risk_rain_last_24hr")
	private String riskRainLast24hr;

	@Column(name="risk_rain_last_72hr")
	private String riskRainLast72hr;

	@Column(name="risk_rain_max_3hr")
	private String riskRainMax3hr;

	private BigDecimal sal;

	@Column(name="sal_f1_2")
	private BigDecimal salF12;

	@Column(name="sal_f2_2")
	private BigDecimal salF22;

	@Column(name="sal_f3_2")
	private BigDecimal salF32;

	@Column(name="sal_f4_2")
	private BigDecimal salF42;

	@Column(name="sal_f5_2")
	private BigDecimal salF52;

	@Column(name="sal_l")
	private BigDecimal salL;

	@Column(name="sal_m")
	private BigDecimal salM;

	@Column(name="sal_o")
	private BigDecimal salO;

	@Column(name="sal_r")
	private BigDecimal salR;

	@Column(name="sal_s1")
	private BigDecimal salS1;

	@Column(name="sal_s1_2")
	private BigDecimal salS12;

	@Column(name="sal_s2")
	private BigDecimal salS2;

	@Column(name="sal_s2_2")
	private BigDecimal salS22;

	@Column(name="sal_s3")
	private BigDecimal salS3;

	@Column(name="sal_s3_2")
	private BigDecimal salS32;

	@Column(name="sal_s4")
	private BigDecimal salS4;

	@Column(name="sal_s4_2")
	private BigDecimal salS42;

	@Column(name="sal_s5")
	private BigDecimal salS5;

	@Column(name="sal_s5_2")
	private BigDecimal salS52;

	@Column(name="sample_date")
	private Timestamp sampleDate;

	@Column(name="sample_no")
	private BigDecimal sampleNo;

	@Column(name="sample_time")
	private String sampleTime;

	private Timestamp sdatetime;

	@Column(name="sea_clarity")
	private String seaClarity;

	@Column(name="sea_clarity_value")
	private BigDecimal seaClarityValue;

	@Column(name="sea_condition")
	private String seaCondition;

	@Column(name="sea_condition_value")
	private BigDecimal seaConditionValue;

	@Column(name="site_id")
	private BigDecimal siteId;

	private BigDecimal stime;

	private BigDecimal temper;

	private String tide;

	@Column(name="tide_height")
	private BigDecimal tideHeight;

	@Column(name="tide_ratio")
	private BigDecimal tideRatio;

	@Column(name="tide_station_code")
	private String tideStationCode;

	@Column(name="tide_value")
	private BigDecimal tideValue;

	private BigDecimal turb;

	private String weather;

	@Column(name="weather_value")
	private BigDecimal weatherValue;

	private String wind;

	@Column(name="wind_direction")
	private String windDirection;

	@Column(name="wind_value")
	private BigDecimal windValue;

	@Column(name="wk_g_mean")
	private BigDecimal wkGMean;

	@Column(name="wk_g_mean_fc")
	private BigDecimal wkGMeanFc;

	public BmVisitLabelSummary() {
	}

	public String getBmvisitId() {
		return this.bmvisitId;
	}

	public void setBmvisitId(String bmvisitId) {
		this.bmvisitId = bmvisitId;
	}

	public BigDecimal getAbsTideHeight() {
		return this.absTideHeight;
	}

	public void setAbsTideHeight(BigDecimal absTideHeight) {
		this.absTideHeight = absTideHeight;
	}

	public BigDecimal getAdjLogGm() {
		return this.adjLogGm;
	}

	public void setAdjLogGm(BigDecimal adjLogGm) {
		this.adjLogGm = adjLogGm;
	}

	public BigDecimal getAdjLogGmFc() {
		return this.adjLogGmFc;
	}

	public void setAdjLogGmFc(BigDecimal adjLogGmFc) {
		this.adjLogGmFc = adjLogGmFc;
	}

	public String getBather() {
		return this.bather;
	}

	public void setBather(String bather) {
		this.bather = bather;
	}

	public BigDecimal getBatherValue() {
		return this.batherValue;
	}

	public void setBatherValue(BigDecimal batherValue) {
		this.batherValue = batherValue;
	}

	public String getBeachCode() {
		return this.beachCode;
	}

	public void setBeachCode(String beachCode) {
		this.beachCode = beachCode;
	}

	public String getBeachGroup() {
		return this.beachGroup;
	}

	public void setBeachGroup(String beachGroup) {
		this.beachGroup = beachGroup;
	}

	public String getBeachName() {
		return this.beachName;
	}

	public void setBeachName(String beachName) {
		this.beachName = beachName;
	}

	public String getClimate() {
		return this.climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public BigDecimal getClimateValue() {
		return this.climateValue;
	}

	public void setClimateValue(BigDecimal climateValue) {
		this.climateValue = climateValue;
	}

	public String getClosed() {
		return this.closed;
	}

	public void setClosed(String closed) {
		this.closed = closed;
	}

	public Timestamp getDayappend() {
		return this.dayappend;
	}

	public void setDayappend(Timestamp dayappend) {
		this.dayappend = dayappend;
	}

	public Timestamp getDayedit() {
		return this.dayedit;
	}

	public void setDayedit(Timestamp dayedit) {
		this.dayedit = dayedit;
	}

	public Timestamp getDayupload() {
		return this.dayupload;
	}

	public void setDayupload(Timestamp dayupload) {
		this.dayupload = dayupload;
	}

	public String getDistrictName() {
		return this.districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictOrder() {
		return this.districtOrder;
	}

	public void setDistrictOrder(String districtOrder) {
		this.districtOrder = districtOrder;
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

	public BigDecimal getEcF1() {
		return this.ecF1;
	}

	public void setEcF1(BigDecimal ecF1) {
		this.ecF1 = ecF1;
	}

	public BigDecimal getEcF2() {
		return this.ecF2;
	}

	public void setEcF2(BigDecimal ecF2) {
		this.ecF2 = ecF2;
	}

	public BigDecimal getEcF3() {
		return this.ecF3;
	}

	public void setEcF3(BigDecimal ecF3) {
		this.ecF3 = ecF3;
	}

	public BigDecimal getEcF4() {
		return this.ecF4;
	}

	public void setEcF4(BigDecimal ecF4) {
		this.ecF4 = ecF4;
	}

	public BigDecimal getEcF5() {
		return this.ecF5;
	}

	public void setEcF5(BigDecimal ecF5) {
		this.ecF5 = ecF5;
	}

	public BigDecimal getEcL() {
		return this.ecL;
	}

	public void setEcL(BigDecimal ecL) {
		this.ecL = ecL;
	}

	public BigDecimal getEcM() {
		return this.ecM;
	}

	public void setEcM(BigDecimal ecM) {
		this.ecM = ecM;
	}

	public BigDecimal getEcO() {
		return this.ecO;
	}

	public void setEcO(BigDecimal ecO) {
		this.ecO = ecO;
	}

	public BigDecimal getEcR() {
		return this.ecR;
	}

	public void setEcR(BigDecimal ecR) {
		this.ecR = ecR;
	}

	public BigDecimal getEcS1() {
		return this.ecS1;
	}

	public void setEcS1(BigDecimal ecS1) {
		this.ecS1 = ecS1;
	}

	public BigDecimal getEcS2() {
		return this.ecS2;
	}

	public void setEcS2(BigDecimal ecS2) {
		this.ecS2 = ecS2;
	}

	public BigDecimal getEcS3() {
		return this.ecS3;
	}

	public void setEcS3(BigDecimal ecS3) {
		this.ecS3 = ecS3;
	}

	public BigDecimal getEcS4() {
		return this.ecS4;
	}

	public void setEcS4(BigDecimal ecS4) {
		this.ecS4 = ecS4;
	}

	public BigDecimal getEcS5() {
		return this.ecS5;
	}

	public void setEcS5(BigDecimal ecS5) {
		this.ecS5 = ecS5;
	}

	public BigDecimal getFcF1() {
		return this.fcF1;
	}

	public void setFcF1(BigDecimal fcF1) {
		this.fcF1 = fcF1;
	}

	public BigDecimal getFcF2() {
		return this.fcF2;
	}

	public void setFcF2(BigDecimal fcF2) {
		this.fcF2 = fcF2;
	}

	public BigDecimal getFcF3() {
		return this.fcF3;
	}

	public void setFcF3(BigDecimal fcF3) {
		this.fcF3 = fcF3;
	}

	public BigDecimal getFcF4() {
		return this.fcF4;
	}

	public void setFcF4(BigDecimal fcF4) {
		this.fcF4 = fcF4;
	}

	public BigDecimal getFcF5() {
		return this.fcF5;
	}

	public void setFcF5(BigDecimal fcF5) {
		this.fcF5 = fcF5;
	}

	public BigDecimal getFcL() {
		return this.fcL;
	}

	public void setFcL(BigDecimal fcL) {
		this.fcL = fcL;
	}

	public BigDecimal getFcM() {
		return this.fcM;
	}

	public void setFcM(BigDecimal fcM) {
		this.fcM = fcM;
	}

	public BigDecimal getFcO() {
		return this.fcO;
	}

	public void setFcO(BigDecimal fcO) {
		this.fcO = fcO;
	}

	public BigDecimal getFcR() {
		return this.fcR;
	}

	public void setFcR(BigDecimal fcR) {
		this.fcR = fcR;
	}

	public BigDecimal getFcS1() {
		return this.fcS1;
	}

	public void setFcS1(BigDecimal fcS1) {
		this.fcS1 = fcS1;
	}

	public BigDecimal getFcS2() {
		return this.fcS2;
	}

	public void setFcS2(BigDecimal fcS2) {
		this.fcS2 = fcS2;
	}

	public BigDecimal getFcS3() {
		return this.fcS3;
	}

	public void setFcS3(BigDecimal fcS3) {
		this.fcS3 = fcS3;
	}

	public BigDecimal getFcS4() {
		return this.fcS4;
	}

	public void setFcS4(BigDecimal fcS4) {
		this.fcS4 = fcS4;
	}

	public BigDecimal getFcS5() {
		return this.fcS5;
	}

	public void setFcS5(BigDecimal fcS5) {
		this.fcS5 = fcS5;
	}

	public String getFlowF1() {
		return this.flowF1;
	}

	public void setFlowF1(String flowF1) {
		this.flowF1 = flowF1;
	}

	public String getFlowF2() {
		return this.flowF2;
	}

	public void setFlowF2(String flowF2) {
		this.flowF2 = flowF2;
	}

	public String getFlowF3() {
		return this.flowF3;
	}

	public void setFlowF3(String flowF3) {
		this.flowF3 = flowF3;
	}

	public String getFlowF4() {
		return this.flowF4;
	}

	public void setFlowF4(String flowF4) {
		this.flowF4 = flowF4;
	}

	public String getFlowF5() {
		return this.flowF5;
	}

	public void setFlowF5(String flowF5) {
		this.flowF5 = flowF5;
	}

	public String getFlowLabelF1() {
		return this.flowLabelF1;
	}

	public void setFlowLabelF1(String flowLabelF1) {
		this.flowLabelF1 = flowLabelF1;
	}

	public String getFlowLabelF2() {
		return this.flowLabelF2;
	}

	public void setFlowLabelF2(String flowLabelF2) {
		this.flowLabelF2 = flowLabelF2;
	}

	public String getFlowLabelF3() {
		return this.flowLabelF3;
	}

	public void setFlowLabelF3(String flowLabelF3) {
		this.flowLabelF3 = flowLabelF3;
	}

	public String getFlowLabelF4() {
		return this.flowLabelF4;
	}

	public void setFlowLabelF4(String flowLabelF4) {
		this.flowLabelF4 = flowLabelF4;
	}

	public String getFlowLabelF5() {
		return this.flowLabelF5;
	}

	public void setFlowLabelF5(String flowLabelF5) {
		this.flowLabelF5 = flowLabelF5;
	}

	public String getFlowLabelS1() {
		return this.flowLabelS1;
	}

	public void setFlowLabelS1(String flowLabelS1) {
		this.flowLabelS1 = flowLabelS1;
	}

	public String getFlowLabelS2() {
		return this.flowLabelS2;
	}

	public void setFlowLabelS2(String flowLabelS2) {
		this.flowLabelS2 = flowLabelS2;
	}

	public String getFlowLabelS3() {
		return this.flowLabelS3;
	}

	public void setFlowLabelS3(String flowLabelS3) {
		this.flowLabelS3 = flowLabelS3;
	}

	public String getFlowLabelS4() {
		return this.flowLabelS4;
	}

	public void setFlowLabelS4(String flowLabelS4) {
		this.flowLabelS4 = flowLabelS4;
	}

	public String getFlowLabelS5() {
		return this.flowLabelS5;
	}

	public void setFlowLabelS5(String flowLabelS5) {
		this.flowLabelS5 = flowLabelS5;
	}

	public String getFlowS1() {
		return this.flowS1;
	}

	public void setFlowS1(String flowS1) {
		this.flowS1 = flowS1;
	}

	public String getFlowS2() {
		return this.flowS2;
	}

	public void setFlowS2(String flowS2) {
		this.flowS2 = flowS2;
	}

	public String getFlowS3() {
		return this.flowS3;
	}

	public void setFlowS3(String flowS3) {
		this.flowS3 = flowS3;
	}

	public String getFlowS4() {
		return this.flowS4;
	}

	public void setFlowS4(String flowS4) {
		this.flowS4 = flowS4;
	}

	public String getFlowS5() {
		return this.flowS5;
	}

	public void setFlowS5(String flowS5) {
		this.flowS5 = flowS5;
	}

	public BigDecimal getGMean() {
		return this.gMean;
	}

	public void setGMean(BigDecimal gMean) {
		this.gMean = gMean;
	}

	public BigDecimal getGMeanFc() {
		return this.gMeanFc;
	}

	public void setGMeanFc(BigDecimal gMeanFc) {
		this.gMeanFc = gMeanFc;
	}

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public BigDecimal getGradeChange() {
		return this.gradeChange;
	}

	public void setGradeChange(BigDecimal gradeChange) {
		this.gradeChange = gradeChange;
	}

	public String getListOrder() {
		return this.listOrder;
	}

	public void setListOrder(String listOrder) {
		this.listOrder = listOrder;
	}

	public BigDecimal getLogGMean() {
		return this.logGMean;
	}

	public void setLogGMean(BigDecimal logGMean) {
		this.logGMean = logGMean;
	}

	public BigDecimal getLogGMeanFc() {
		return this.logGMeanFc;
	}

	public void setLogGMeanFc(BigDecimal logGMeanFc) {
		this.logGMeanFc = logGMeanFc;
	}

	public Timestamp getMdate() {
		return this.mdate;
	}

	public void setMdate(Timestamp mdate) {
		this.mdate = mdate;
	}

	public BigDecimal getMoveAvg() {
		return this.moveAvg;
	}

	public void setMoveAvg(BigDecimal moveAvg) {
		this.moveAvg = moveAvg;
	}

	public BigDecimal getMoveAvgFc() {
		return this.moveAvgFc;
	}

	public void setMoveAvgFc(BigDecimal moveAvgFc) {
		this.moveAvgFc = moveAvgFc;
	}

	public BigDecimal getMrefuseCleanlinesLevel() {
		return this.mrefuseCleanlinesLevel;
	}

	public void setMrefuseCleanlinesLevel(BigDecimal mrefuseCleanlinesLevel) {
		this.mrefuseCleanlinesLevel = mrefuseCleanlinesLevel;
	}

	public BigDecimal getMthGMean() {
		return this.mthGMean;
	}

	public void setMthGMean(BigDecimal mthGMean) {
		this.mthGMean = mthGMean;
	}

	public BigDecimal getMthGMeanFc() {
		return this.mthGMeanFc;
	}

	public void setMthGMeanFc(BigDecimal mthGMeanFc) {
		this.mthGMeanFc = mthGMeanFc;
	}

	public BigDecimal getPh() {
		return this.ph;
	}

	public void setPh(BigDecimal ph) {
		this.ph = ph;
	}

	public BigDecimal getRGMean() {
		return this.rGMean;
	}

	public void setRGMean(BigDecimal rGMean) {
		this.rGMean = rGMean;
	}

	public BigDecimal getRGMeanFc() {
		return this.rGMeanFc;
	}

	public void setRGMeanFc(BigDecimal rGMeanFc) {
		this.rGMeanFc = rGMeanFc;
	}

	public String getRainStationCode() {
		return this.rainStationCode;
	}

	public void setRainStationCode(String rainStationCode) {
		this.rainStationCode = rainStationCode;
	}

	public BigDecimal getRainfall() {
		return this.rainfall;
	}

	public void setRainfall(BigDecimal rainfall) {
		this.rainfall = rainfall;
	}

	public BigDecimal getRainfallLast12hr() {
		return this.rainfallLast12hr;
	}

	public void setRainfallLast12hr(BigDecimal rainfallLast12hr) {
		this.rainfallLast12hr = rainfallLast12hr;
	}

	public BigDecimal getRainfallLast24hr() {
		return this.rainfallLast24hr;
	}

	public void setRainfallLast24hr(BigDecimal rainfallLast24hr) {
		this.rainfallLast24hr = rainfallLast24hr;
	}

	public BigDecimal getRainfallLast72hr() {
		return this.rainfallLast72hr;
	}

	public void setRainfallLast72hr(BigDecimal rainfallLast72hr) {
		this.rainfallLast72hr = rainfallLast72hr;
	}

	public BigDecimal getRainfallMax3hr() {
		return this.rainfallMax3hr;
	}

	public void setRainfallMax3hr(BigDecimal rainfallMax3hr) {
		this.rainfallMax3hr = rainfallMax3hr;
	}

	public Timestamp getRainfallMaxTime() {
		return this.rainfallMaxTime;
	}

	public void setRainfallMaxTime(Timestamp rainfallMaxTime) {
		this.rainfallMaxTime = rainfallMaxTime;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRiskRainLast12hr() {
		return this.riskRainLast12hr;
	}

	public void setRiskRainLast12hr(String riskRainLast12hr) {
		this.riskRainLast12hr = riskRainLast12hr;
	}

	public String getRiskRainLast24hr() {
		return this.riskRainLast24hr;
	}

	public void setRiskRainLast24hr(String riskRainLast24hr) {
		this.riskRainLast24hr = riskRainLast24hr;
	}

	public String getRiskRainLast72hr() {
		return this.riskRainLast72hr;
	}

	public void setRiskRainLast72hr(String riskRainLast72hr) {
		this.riskRainLast72hr = riskRainLast72hr;
	}

	public String getRiskRainMax3hr() {
		return this.riskRainMax3hr;
	}

	public void setRiskRainMax3hr(String riskRainMax3hr) {
		this.riskRainMax3hr = riskRainMax3hr;
	}

	public BigDecimal getSal() {
		return this.sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public BigDecimal getSalF12() {
		return this.salF12;
	}

	public void setSalF12(BigDecimal salF12) {
		this.salF12 = salF12;
	}

	public BigDecimal getSalF22() {
		return this.salF22;
	}

	public void setSalF22(BigDecimal salF22) {
		this.salF22 = salF22;
	}

	public BigDecimal getSalF32() {
		return this.salF32;
	}

	public void setSalF32(BigDecimal salF32) {
		this.salF32 = salF32;
	}

	public BigDecimal getSalF42() {
		return this.salF42;
	}

	public void setSalF42(BigDecimal salF42) {
		this.salF42 = salF42;
	}

	public BigDecimal getSalF52() {
		return this.salF52;
	}

	public void setSalF52(BigDecimal salF52) {
		this.salF52 = salF52;
	}

	public BigDecimal getSalL() {
		return this.salL;
	}

	public void setSalL(BigDecimal salL) {
		this.salL = salL;
	}

	public BigDecimal getSalM() {
		return this.salM;
	}

	public void setSalM(BigDecimal salM) {
		this.salM = salM;
	}

	public BigDecimal getSalO() {
		return this.salO;
	}

	public void setSalO(BigDecimal salO) {
		this.salO = salO;
	}

	public BigDecimal getSalR() {
		return this.salR;
	}

	public void setSalR(BigDecimal salR) {
		this.salR = salR;
	}

	public BigDecimal getSalS1() {
		return this.salS1;
	}

	public void setSalS1(BigDecimal salS1) {
		this.salS1 = salS1;
	}

	public BigDecimal getSalS12() {
		return this.salS12;
	}

	public void setSalS12(BigDecimal salS12) {
		this.salS12 = salS12;
	}

	public BigDecimal getSalS2() {
		return this.salS2;
	}

	public void setSalS2(BigDecimal salS2) {
		this.salS2 = salS2;
	}

	public BigDecimal getSalS22() {
		return this.salS22;
	}

	public void setSalS22(BigDecimal salS22) {
		this.salS22 = salS22;
	}

	public BigDecimal getSalS3() {
		return this.salS3;
	}

	public void setSalS3(BigDecimal salS3) {
		this.salS3 = salS3;
	}

	public BigDecimal getSalS32() {
		return this.salS32;
	}

	public void setSalS32(BigDecimal salS32) {
		this.salS32 = salS32;
	}

	public BigDecimal getSalS4() {
		return this.salS4;
	}

	public void setSalS4(BigDecimal salS4) {
		this.salS4 = salS4;
	}

	public BigDecimal getSalS42() {
		return this.salS42;
	}

	public void setSalS42(BigDecimal salS42) {
		this.salS42 = salS42;
	}

	public BigDecimal getSalS5() {
		return this.salS5;
	}

	public void setSalS5(BigDecimal salS5) {
		this.salS5 = salS5;
	}

	public BigDecimal getSalS52() {
		return this.salS52;
	}

	public void setSalS52(BigDecimal salS52) {
		this.salS52 = salS52;
	}

	public Timestamp getSampleDate() {
		return this.sampleDate;
	}

	public void setSampleDate(Timestamp sampleDate) {
		this.sampleDate = sampleDate;
	}

	public BigDecimal getSampleNo() {
		return this.sampleNo;
	}

	public void setSampleNo(BigDecimal sampleNo) {
		this.sampleNo = sampleNo;
	}

	public String getSampleTime() {
		return this.sampleTime;
	}

	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}

	public Timestamp getSdatetime() {
		return this.sdatetime;
	}

	public void setSdatetime(Timestamp sdatetime) {
		this.sdatetime = sdatetime;
	}

	public String getSeaClarity() {
		return this.seaClarity;
	}

	public void setSeaClarity(String seaClarity) {
		this.seaClarity = seaClarity;
	}

	public BigDecimal getSeaClarityValue() {
		return this.seaClarityValue;
	}

	public void setSeaClarityValue(BigDecimal seaClarityValue) {
		this.seaClarityValue = seaClarityValue;
	}

	public String getSeaCondition() {
		return this.seaCondition;
	}

	public void setSeaCondition(String seaCondition) {
		this.seaCondition = seaCondition;
	}

	public BigDecimal getSeaConditionValue() {
		return this.seaConditionValue;
	}

	public void setSeaConditionValue(BigDecimal seaConditionValue) {
		this.seaConditionValue = seaConditionValue;
	}

	public BigDecimal getSiteId() {
		return this.siteId;
	}

	public void setSiteId(BigDecimal siteId) {
		this.siteId = siteId;
	}

	public BigDecimal getStime() {
		return this.stime;
	}

	public void setStime(BigDecimal stime) {
		this.stime = stime;
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

	public BigDecimal getTideHeight() {
		return this.tideHeight;
	}

	public void setTideHeight(BigDecimal tideHeight) {
		this.tideHeight = tideHeight;
	}

	public BigDecimal getTideRatio() {
		return this.tideRatio;
	}

	public void setTideRatio(BigDecimal tideRatio) {
		this.tideRatio = tideRatio;
	}

	public String getTideStationCode() {
		return this.tideStationCode;
	}

	public void setTideStationCode(String tideStationCode) {
		this.tideStationCode = tideStationCode;
	}

	public BigDecimal getTideValue() {
		return this.tideValue;
	}

	public void setTideValue(BigDecimal tideValue) {
		this.tideValue = tideValue;
	}

	public BigDecimal getTurb() {
		return this.turb;
	}

	public void setTurb(BigDecimal turb) {
		this.turb = turb;
	}

	public String getWeather() {
		return this.weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public BigDecimal getWeatherValue() {
		return this.weatherValue;
	}

	public void setWeatherValue(BigDecimal weatherValue) {
		this.weatherValue = weatherValue;
	}

	public String getWind() {
		return this.wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getWindDirection() {
		return this.windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public BigDecimal getWindValue() {
		return this.windValue;
	}

	public void setWindValue(BigDecimal windValue) {
		this.windValue = windValue;
	}

	public BigDecimal getWkGMean() {
		return this.wkGMean;
	}

	public void setWkGMean(BigDecimal wkGMean) {
		this.wkGMean = wkGMean;
	}

	public BigDecimal getWkGMeanFc() {
		return this.wkGMeanFc;
	}

	public void setWkGMeanFc(BigDecimal wkGMeanFc) {
		this.wkGMeanFc = wkGMeanFc;
	}

}