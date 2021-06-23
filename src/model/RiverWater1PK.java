package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the river_water1 database table.
 * 
 */
@Embeddable
public class RiverWater1PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String station;

	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date mdate;

	public RiverWater1PK() {
	}
	public String getStation() {
		return this.station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public java.util.Date getMdate() {
		return this.mdate;
	}
	public void setMdate(java.util.Date mdate) {
		this.mdate = mdate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RiverWater1PK)) {
			return false;
		}
		RiverWater1PK castOther = (RiverWater1PK)other;
		return 
			this.station.equals(castOther.station)
			&& this.mdate.equals(castOther.mdate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.station.hashCode();
		hash = hash * prime + this.mdate.hashCode();
		
		return hash;
	}
}