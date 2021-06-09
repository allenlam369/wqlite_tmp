package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bm_beach_ec_agm_rank_report database table.
 * 
 */
@Embeddable
public class BmBeachEcAgmRankReportPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="beach_code")
	private String beachCode;

	@Column(name="year_")
	private Integer year;

	public BmBeachEcAgmRankReportPK() {
	}
	public String getBeachCode() {
		return this.beachCode;
	}
	public void setBeachCode(String beachCode) {
		this.beachCode = beachCode;
	}
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BmBeachEcAgmRankReportPK)) {
			return false;
		}
		BmBeachEcAgmRankReportPK castOther = (BmBeachEcAgmRankReportPK)other;
		return 
			this.beachCode.equals(castOther.beachCode)
			&& this.year.equals(castOther.year);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.beachCode.hashCode();
		hash = hash * prime + this.year.hashCode();
		
		return hash;
	}
}