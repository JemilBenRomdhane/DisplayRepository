package com.utina.core.display.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class ParPageListResponse {

	
	@Id private String pagcode;
	private String pagmodule;
	private String pagurl;
	private String pagicon;
	private String paglabel;
	private boolean flaglanding;
	
public ParPageListResponse (String pagcode,String pagmodule,String pagurl, String pagicon,String paglabel,boolean flaglanding) {
	this.pagcode=pagcode;
	this.pagmodule=pagmodule;
	this.pagurl=pagurl;
	this.pagicon=pagicon;
	this.paglabel=paglabel;
	this.flaglanding=flaglanding;
	
}
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
	public String getPaglabel() {
		return paglabel;
	}
	public void setPaglabel(String paglabel) {
		this.paglabel = paglabel;
	}
	public boolean isFlaglanding() {
		return flaglanding;
	}
	public void setFlaglanding(boolean flaglanding) {
		this.flaglanding = flaglanding;
	}
	
		
}
