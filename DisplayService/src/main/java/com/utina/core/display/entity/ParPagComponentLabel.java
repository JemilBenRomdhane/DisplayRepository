package com.utina.core.display.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "parpagcomponentlabel")
public class ParPagComponentLabel  {

	@Id
	private String comcode;
	private String pagcode;
	private String comlabel;
	private String complaceholder;
	private String comhint;
	private String lancode;
	private String commessage;
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}
	public String getComlabel() {
		return comlabel;
	}
	public void setComlabel(String comlabel) {
		this.comlabel = comlabel;
	}
	public String getComplaceholder() {
		return complaceholder;
	}
	public void setComplaceholder(String complaceholder) {
		this.complaceholder = complaceholder;
	}
	public String getComhint() {
		return comhint;
	}
	public void setComhint(String comhint) {
		this.comhint = comhint;
	}
	public String getLancode() {
		return lancode;
	}
	public void setLancode(String lancode) {
		this.lancode = lancode;
	}
	public String getCommessage() {
		return commessage;
	}
	public void setCommessage(String commessage) {
		this.commessage = commessage;
	}


	
	
}
