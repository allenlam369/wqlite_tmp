package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the river_water_wqo_sum0 database table.
 * 
 */
@Embeddable
public class RiverWaterWqoSum0PK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String station;

	private Integer yr;

	public RiverWaterWqoSum0PK() {
	}
	public String getStation() {
		return this.station;
	}
	public void setStation(String station) {
		this.station = station;
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
		if (!(other instanceof RiverWaterWqoSum0PK)) {
			return false;
		}
		RiverWaterWqoSum0PK castOther = (RiverWaterWqoSum0PK)other;
		return 
			this.station.equals(castOther.station)
			&& this.yr.equals(castOther.yr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.station.hashCode();
		hash = hash * prime + this.yr.hashCode();
		
		return hash;
	}
}