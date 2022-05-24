package com.utina.core.display.entity;


import java.time.Instant;
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

@NamedStoredProcedureQuery(name = "f_update_userlocked", procedureName = "plus1inout", parameters = {
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Long.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilocked", type = boolean.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "nb", type = int.class) })

@NamedStoredProcedureQuery(name = "f_update_userstatus", procedureName = "plus1inout", parameters = {
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Long.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "istatus", type = String.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "nb", type = int.class) })


@NamedStoredProcedureQuery(name = "f_set_userid", procedureName = "plus1inout", parameters = {
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Long.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "userid", type = Long.class) })




@Table(name = "users")
public class Users {

	@Id
	private Long id;
	
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Long mgid;
	private String userrole;
	private String lancode;
	private String status;
	private boolean locked;
	private String phone;
	private String mobile;
	private Instant created_at;
	private Instant updated_at;
	private boolean changepassword;
	private String route;
	private String usertype;
	private String tabposition;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMgid() {
		return mgid;
	}
	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public String getLancode() {
		return lancode;
	}
	public void setLancode(String lancode) {
		this.lancode = lancode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Instant getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}
	public Instant getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}
	public boolean isChangepassword() {
		return changepassword;
	}
	public void setChangepassword(boolean changepassword) {
		this.changepassword = changepassword;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getTabposition() {
		return tabposition;
	}
	public void setTabposition(String tabposition) {
		this.tabposition = tabposition;
	}
	
	
}
