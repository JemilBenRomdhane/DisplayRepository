package com.utina.core.display.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "menusroles")
public class ViewMenusRoles {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long associd;
	private Long menuid;
	private String rolcode;
	public Long getAssocid() {
		return associd;
	}
	public void setAssocid(Long associd) {
		this.associd = associd;
	}
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getRolcode() {
		return rolcode;
	}
	public void setRolcode(String rolcode) {
		this.rolcode = rolcode;
	}
	
	
		
	}
