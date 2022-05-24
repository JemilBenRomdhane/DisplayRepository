package com.utina.core.display.entity;


import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "parpagelabel")
@IdClass(ParPageLabelPK.class)
public class ParPageLabel implements Serializable {

	@Id private String pagcode;
	@Id private String lancode;
	private String paglabel;
	

	
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}
	public String getLancode() {
		return lancode;
	}
	public void setLancode(String lancode) {
		this.lancode = lancode;
	}
	public String getPaglabel() {
		return paglabel;
	}
	public void setPaglabel(String paglabel) {
		this.paglabel = paglabel;
	}
	
	
}
