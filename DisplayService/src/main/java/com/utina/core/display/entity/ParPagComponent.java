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
@Table(name = "parpagcomponent")
public class ParPagComponent  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
 	@JoinColumn(name = "pagcode", nullable = false)
 	private ParPage page;

 	public ParPagComponent() {

    }

    public ParPagComponent(String comtype,String comstyle,String comformat,Boolean comrequired) {

    	this.comtype=comtype;
    	this.comstyle=comstyle;
    	this.comformat=comformat;
    	this.comrequired=comrequired;

    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comid == null) ? 0 : comid.hashCode());
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
		ParPagComponent other = (ParPagComponent) obj;
		if (comid == null) {
			if (other.comid != null)
				return false;
		} else if (!comid.equals(other.comid))
			return false;
		return true;
	}
	
	
	private String comcode;
	private String comtype;
	private String comstyle;
	private String comformat;
	private Boolean comrequired;
	
	
	
	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getComtype() {
		return comtype;
	}
	public void setComtype(String comtype) {
		this.comtype = comtype;
	}
	public String getComstyle() {
		return comstyle;
	}
	public void setComstyle(String comstyle) {
		this.comstyle = comstyle;
	}
	public String getComformat() {
		return comformat;
	}
	public void setComformat(String comformat) {
		this.comformat = comformat;
	}
	public Boolean getComrequired() {
		return comrequired;
	}
	public void setComrequired(Boolean comrequired) {
		this.comrequired = comrequired;
	}


	public void setPage(ParPage page) {
		this.page = page;
	}
	

	
	
}
