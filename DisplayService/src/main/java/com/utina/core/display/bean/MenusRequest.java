package com.utina.core.display.bean;

import java.util.ArrayList;
import java.util.List;

public class MenusRequest {

	private Long menuid;
	private String menulabel;
	private String menudescription;
	private String menustatus;

	private List<MenusItemRequest> MenusItems = new ArrayList<>();
	private List<MenusRolesRequest> MenusRoles = new ArrayList<>();
	private List<MenusUsersRequest> MenusUsers = new ArrayList<>();
	
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
	public List<MenusItemRequest> getMenusItems() {
		return MenusItems;
	}
	public void setMenusItems(List<MenusItemRequest> menusItems) {
		MenusItems = menusItems;
	}
	public List<MenusRolesRequest> getMenusRoles() {
		return MenusRoles;
	}
	public void setMenusRoles(List<MenusRolesRequest> menusRoles) {
		MenusRoles = menusRoles;
	}
	public List<MenusUsersRequest> getMenusUsers() {
		return MenusUsers;
	}
	public void setMenusUsers(List<MenusUsersRequest> menusUsers) {
		MenusUsers = menusUsers;
	}
	
	

}
