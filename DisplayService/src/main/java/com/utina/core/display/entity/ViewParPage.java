package com.utina.core.display.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "parpage")
public class ViewParPage {

	@Id
	private String pagcode;
	private String pagmodule;
	private String pagurl;
	private String pagicon;
	private boolean flaglanding;
	
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}
	public String getPagmodule() {
		return pagmodule;
	}
	public void setPagmodule(String pagmodule) {
		this.pagmodule = pagmodule;
	}
	public String getPagurl() {
		return pagurl;
	}
	public void setPagurl(String pagurl) {
		this.pagurl = pagurl;
	}
	public String getPagicon() {
		return pagicon;
	}
	public void setPagicon(String pagicon) {
		this.pagicon = pagicon;
	}
	public boolean isFlaglanding() {
		return flaglanding;
	}
	public void setFlaglanding(boolean flaglanding) {
		this.flaglanding = flaglanding;
	}
	
		
}
