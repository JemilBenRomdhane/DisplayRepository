package com.utina.core.display.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

@Entity

@NamedStoredProcedureQuery(name = "f_set_menuitem_id", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "userid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "return", type = Long.class) })

@Table(name = "menusitem")
public class MenusItem {

	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pitemid;
		


	private Long itemid;
	
	private Integer itemorder;
	private Long itemidparent;
	private String pagcode;
	private String itemlabel;
	private String pagparams;
	private String menuicon;
	
	private Long menuid;
	
	
	
	
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
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
