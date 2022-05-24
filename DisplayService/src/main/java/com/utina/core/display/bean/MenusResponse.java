package com.utina.core.display.bean;

import java.util.ArrayList;
import java.util.List;

public class MenusResponse {

	private Long menuid;
	private String menulabel;
	private String menudescription;
	private String menustatus;
	private String statuslabel;
	

	private List<MenusItemResponse> MenusItems = new ArrayList<>();
	private List<MenusRolesResponse> MenusRoles = new ArrayList<>();
	private List<MenusUsersResponse> MenusUsers = new ArrayList<>();
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
	public String getStatuslabel() {
		return statuslabel;
	}
	public void setStatuslabel(String statuslabel) {
		this.statuslabel = statuslabel;
	}
	public List<MenusItemResponse> getMenusItems() {
		return MenusItems;
	}
	public void setMenusItems(List<MenusItemResponse> menusItems) {
		MenusItems = menusItems;
	}
	public List<MenusRolesResponse> getMenusRoles() {
		return MenusRoles;
	}
	public void setMenusRoles(List<MenusRolesResponse> menusRoles) {
		MenusRoles = menusRoles;
	}
	public List<MenusUsersResponse> getMenusUsers() {
		return MenusUsers;
	}
	public void setMenusUsers(List<MenusUsersResponse> menusUsers) {
		MenusUsers = menusUsers;
	}
	
	
}
