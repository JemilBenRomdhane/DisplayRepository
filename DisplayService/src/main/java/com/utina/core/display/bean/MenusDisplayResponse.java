package com.utina.core.display.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MenusDisplayResponse {

	@Id
	private Long pitemid;
	private Long itemid;
	private String itemlabel;
	private Long itemidparent;
	private Integer itemorder;
	private String pagcode;
	private String pagurl;
	private String pagicon;
	private String paglabel;
	private String pagparams;
	
	public MenusDisplayResponse (Long pitemid,Long itemid,String itemlabel,Long itemidparent,Integer itemorder,
			String pagcode,String pagurl,String pagicon,String paglabel,String pagparams) {
		
		this.itemid=itemid;
		this.itemidparent=itemidparent;
		this.itemlabel=itemlabel;
		this.itemorder=itemorder;
		this.pagcode=pagcode;
		this.pagicon=pagicon;
		this.paglabel=paglabel;
		this.pagurl=pagurl;
		this.pitemid=pitemid;
		this.pagparams=pagparams;
		
	}
	
	public Long getPitemid() {
		return pitemid;
	}
	public void setPitemid(Long pitemid) {
		this.pitemid = pitemid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public String getItemlabel() {
		return itemlabel;
	}
	public void setItemlabel(String itemlabel) {
		this.itemlabel = itemlabel;
	}
	public Long getItemidparent() {
		return itemidparent;
	}
	public void setItemidparent(Long itemidparent) {
		this.itemidparent = itemidparent;
	}
	public Integer getItemorder() {
		return itemorder;
	}
	public void setItemorder(Integer itemorder) {
		this.itemorder = itemorder;
	}
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
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

	public String getPagparams() {
		return pagparams;
	}

	public void setPagparams(String pagparams) {
		this.pagparams = pagparams;
	}
	
	
	
	
}
