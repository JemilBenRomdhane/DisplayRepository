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
@Table(name = "menususers")
public class MenusUsers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long associd;

	private Long menuid;
	
	private Long userid;

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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	
}
