package com.utina.core.display.bean;




public class ParPagComFilteringRequest {

	
	private String comcode;
	private String comlabel;
	private Boolean flaghide;
	private Boolean flagrequired;
	private Boolean flagdisabled;

	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getComlabel() {
		return comlabel;
	}
	public void setComlabel(String comlabel) {
		this.comlabel = comlabel;
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
