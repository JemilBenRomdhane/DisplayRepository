package com.utina.core.display.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity (name="vparlist")
@Immutable
public class ParList {
	@Id
	@Column(name = "ID")
    private Long ID;
	
	@Column(name = "mgid")
	private Long mgid;
	
	@Column(name = "parmodule")
	private String parmodule;
	
	@Column(name = "parcode")
	private String parcode;
	
	@Column(name = "lancode")
	private String lancode;

	
	@Column(name = "parvalue")
	private String parvalue;
	
	@Column(name = "parvalueparent")
	private String parvalueparent;

	@Column(name = "parlistlabel")
	private String parlistlabel;
	
	@Column(name = "parflagdefault")
	private boolean parflagdefault;

	

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getMgid() {
		return mgid;
	}

	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}

	public String getParmodule() {
		return parmodule;
	}

	public void setParmodule(String parmodule) {
		this.parmodule = parmodule;
	}

	public String getParcode() {
		return parcode;
	}

	public void setParcode(String parcode) {
		this.parcode = parcode;
	}

	public String getLancode() {
		return lancode;
	}

	public void setLancode(String lancode) {
		this.lancode = lancode;
	}

	public String getParvalue() {
		return parvalue;
	}

	public void setParvalue(String parvalue) {
		this.parvalue = parvalue;
	}

	public String getParlistlabel() {
		return parlistlabel;
	}

	public void setParlistlabel(String parlistlabel) {
		this.parlistlabel = parlistlabel;
	}

	public boolean isParflagdefault() {
		return parflagdefault;
	}

	public void setParflagdefault(boolean parflagdefault) {
		this.parflagdefault = parflagdefault;
	}

	public String getParvalueparent() {
		return parvalueparent;
	}

	public void setParvalueparent(String parvalueparent) {
		this.parvalueparent = parvalueparent;
	}

	
	
	
}
