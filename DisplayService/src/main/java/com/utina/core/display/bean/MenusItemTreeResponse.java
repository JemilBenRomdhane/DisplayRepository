package com.utina.core.display.bean;

import java.util.ArrayList;
import java.util.List;

public class MenusItemTreeResponse {
	
	private String key;
	private String title;
	private boolean checkable;
	private boolean disableCheckbox;
	private boolean disabled;
	private String icon;
	private boolean isLeaf;
	private boolean selectable;

	private String pagcode;
	private String paglabel;
	private String pagurl;
	private Long pitemid;
	private Long menuid;
	private Long itemid;
	private Integer itemorder;
	private Long itemidparent;
	private String itemlabel;
	private String pagparams;
	private String menuicon;

	List<MenusItemTreeResponse> children = new ArrayList();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCheckable() {
		return checkable;
	}

	public void setCheckable(boolean checkable) {
		this.checkable = checkable;
	}

	public boolean isDisableCheckbox() {
		return disableCheckbox;
	}

	public void setDisableCheckbox(boolean disableCheckbox) {
		this.disableCheckbox = disableCheckbox;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public String getPagcode() {
		return pagcode;
	}

	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}

	public String getPaglabel() {
		return paglabel;
	}

	public void setPaglabel(String paglabel) {
		this.paglabel = paglabel;
	}

	public String getPagurl() {
		return pagurl;
	}

	public void setPagurl(String pagurl) {
		this.pagurl = pagurl;
	}

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

	public List<MenusItemTreeResponse> getChildren() {
		return children;
	}

	public void setChildren(List<MenusItemTreeResponse> children) {
		this.children = children;
	}
	
	
	
	
}
