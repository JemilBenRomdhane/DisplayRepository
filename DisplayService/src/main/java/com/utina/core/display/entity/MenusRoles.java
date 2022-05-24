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
@Table(name = "menusroles")
public class MenusRoles {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long associd;

	private String rolcode;
	
	private Long menuid;

	
	
	public Long getAssocid() {
		return associd;
	}

	public void setAssocid(Long associd) {
		this.associd = associd;
	}

	public String getRolcode() {
		return rolcode;
	}

	public void setRolcode(String rolcode) {
		this.rolcode = rolcode;
	}

	public Long getMenuid() {
		return menuid;
	}

	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	
	
	

	
}
