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
@Table(name = "menusitem")
public class ViewMenusItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pitemid;
		
	
	private Long menuid;
	private Long itemid;
	private Integer itemorder;
	private Long itemidparent;
	private String pagcode;
	private String itemlabel;
	private String pagparams;
	private String menuicon;
	
	
	public Long getPitemid() {
		return pitemid;
	}
	public void setPitemid(Long pitemid) {
		this.pitemid = pitemid;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Integer getItemorder() {
		return itemorder;
	}
	public void setItemorder(Integer itemorder) {
		this.itemorder = itemorder;
	}
	public Long getItemidparent() {
		return itemidparent;
	}
	public void setItemidparent(Long itemidparent) {
		this.itemidparent = itemidparent;
	}
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}
	public String getItemlabel() {
		return itemlabel;
	}
	public void setItemlabel(String itemlabel) {
		this.itemlabel = itemlabel;
	}
	public String getPagparams() {
		return pagparams;
	}
	public void setPagparams(String pagparams) {
		this.pagparams = pagparams;
	}
	public String getMenuicon() {
		return menuicon;
	}
	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}

	
}
