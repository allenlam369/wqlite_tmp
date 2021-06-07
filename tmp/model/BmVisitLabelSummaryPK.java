package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the bm_visit_label_summary database table.
 * 
 */
@Embeddable
public class BmVisitLabelSummaryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="beach_code", insertable=false, updatable=false)
	private String beachCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sample_date")
	private java.util.Date sampleDate;

	public BmVisitLabelSummaryPK() {
	}
	public String getBeachCode() {
		return this.beachCode;
	}
	public void setBeachCode(String beachCode) {
		this.beachCode = beachCode;
	}
	public java.util.Date getSampleDate() {
		return this.sampleDate;
	}
	public void setSampleDate(java.util.Date sampleDate) {
		this.sampleDate = sampleDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BmVisitLabelSummaryPK)) {
			return false;
		}
		BmVisitLabelSummaryPK castOther = (BmVisitLabelSummaryPK)other;
		return 
			this.beachCode.equals(castOther.beachCode)
			&& this.sampleDate.equals(castOther.sampleDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.beachCode.hashCode();
		hash = hash * prime + this.sampleDate.hashCode();
		
		return hash;
	}
}