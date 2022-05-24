package com.utina.core.display.bean;

import java.util.ArrayList;
import java.util.List;

import com.utina.core.display.entity.ParPagComponent;
import com.utina.core.display.entity.ParPagFiltering;

public class ParPageRequest {

	private String pagcode;
	
    private List<ParPagComponentRequest> ParPagComponents = new ArrayList<>();

    private List<ParPagFilteringRequest> ParPagFilterings = new ArrayList<>();

	private String pagmodule;
	private String pagurl;
	private String pagicon;
	private String paglabel;
	private boolean flaglanding;
	
	public boolean isFlaglanding() {
		return flaglanding;
	}
	public void setFlaglanding(boolean flaglanding) {
		this.flaglanding = flaglanding;
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
	public List<ParPagComponentRequest> getParPagComponents() {
		return ParPagComponents;
	}
	public void setParPagComponents(List<ParPagComponentRequest> parPagComponents) {
		ParPagComponents = parPagComponents;
	}
	public List<ParPagFilteringRequest> getParPagFilterings() {
		return ParPagFilterings;
	}
	public void setParPagFilterings(List<ParPagFilteringRequest> parPagFilterings) {
		ParPagFilterings = parPagFilterings;
	}

	
	
}
