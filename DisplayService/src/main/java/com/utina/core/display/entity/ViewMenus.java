package com.utina.core.display.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class ViewMenus {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuid;
		
	private String menulabel;
	private String menudescription;
	private String menustatus;
	
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getMenulabel() {
		return menulabel;
	}
	public void setMenulabel(String menulabel) {
		this.menulabel = menulabel;
	}
	public String getMenudescription() {
		return menudescription;
	}
	public void setMenudescription(String menudescription) {
		this.menudescription = menudescription;
	}
	public String getMenustatus() {
		return menustatus;
	}
	public void setMenustatus(String menustatus) {
		this.menustatus = menustatus;
	}
		
}
