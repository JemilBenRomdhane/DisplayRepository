package com.utina.core.display.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity

@NamedStoredProcedureQuery(name = "f_update_menustatus", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "imenuid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "istatus", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "return", type = Integer.class) })

@Table(name = "menus")
public class Menus {

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
