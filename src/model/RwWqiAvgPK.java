package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rw_wqi_avg database table.
 * 
 */
@Embeddable
public class RwWqiAvgPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="site_id", insertable=false, updatable=false)
	private long siteId;

	private Integer yr;

	public RwWqiAvgPK() {
	}
	public long getSiteId() {
		return this.siteId;
	}
	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}
	public Integer getYr() {
		return this.yr;
	}
	public void setYr(Integer yr) {
		this.yr = yr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RwWqiAvgPK)) {
			return false;
		}
		RwWqiAvgPK castOther = (RwWqiAvgPK)other;
		return 
			(this.siteId == castOther.siteId)
			&& this.yr.equals(castOther.yr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.siteId ^ (this.siteId >>> 32)));
		hash = hash * prime + this.yr.hashCode();
		
		return hash;
	}
}