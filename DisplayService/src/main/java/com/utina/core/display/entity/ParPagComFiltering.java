package com.utina.core.display.entity;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "parpagcomfiltering")
public class ParPagComFiltering {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comfilterid;
		
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
 	@JoinColumn(name = "filterid", nullable = false)
 	private ParPagFiltering parPagFiltering;

 	public ParPagComFiltering() {

    }

    public ParPagComFiltering(String comcode,Boolean flaghide,Boolean flagrequired) {

	this.comcode=comcode;
	this.flaghide=flaghide;
	this.flagrequired=flagrequired;
		
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comfilterid == null) ? 0 : comfilterid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParPagComFiltering other = (ParPagComFiltering) obj;
		if (comfilterid == null) {
			if (other.comfilterid != null)
				return false;
		} else if (!comfilterid.equals(other.comfilterid))
			return false;
		return true;
	}

	private String comcode;
	private Boolean flaghide;
	private Boolean flagrequired;
	private Boolean flagdisabled;

	public Long getComfilterid() {
		return comfilterid;
	}

	public void setComfilterid(Long comfilterid) {
		this.comfilterid = comfilterid;
	}


	public void setParPagFiltering(ParPagFiltering parPagFiltering) {
		this.parPagFiltering = parPagFiltering;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public Boolean getFlaghide() {
		return flaghide;
	}

	public void setFlaghide(Boolean flaghide) {
		this.flaghide = flaghide;
	}

	public Boolean getFlagrequired() {
		return flagrequired;
	}

	public void setFlagrequired(Boolean flagrequired) {
		this.flagrequired = flagrequired;
	}

	public Boolean getFlagdisabled() {
		return flagdisabled;
	}

	public void setFlagdisabled(Boolean flagdisabled) {
		this.flagdisabled = flagdisabled;
	}
	
	
	
	
}
