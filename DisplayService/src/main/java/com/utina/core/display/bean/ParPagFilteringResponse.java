package com.utina.core.display.bean;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


public class ParPagFilteringResponse  {

	private Long filterid;
	
	private String userrole;
	private Long mgid;
	private Long userid;
	private String filterdescription;
	private String rolelabel;
	private String username;
	
	private boolean flagcreationmode;
	private String objecttype;
	private String objectphase;
	private String objectstatus;
	private String prcode;
	private int prioritylevel;
	
    private List<ParPagComFilteringResponse> ParPagComFilterings = new ArrayList<>();

	public Long getFilterid() {
		return filterid;
	}

	public void setFilterid(Long filterid) {
		this.filterid = filterid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public Long getMgid() {
		return mgid;
	}

	public void setMgid(Long mgid) {
		this.mgid = mgid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getFilterdescription() {
		return filterdescription;
	}

	public void setFilterdescription(String filterdescription) {
		this.filterdescription = filterdescription;
	}

	public String getRolelabel() {
		return rolelabel;
	}

	public void setRolelabel(String rolelabel) {
		this.rolelabel = rolelabel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ParPagComFilteringResponse> getParPagComFilterings() {
		return ParPagComFilterings;
	}

	public void setParPagComFilterings(List<ParPagComFilteringResponse> parPagComFilterings) {
		ParPagComFilterings = parPagComFilterings;
	}

	public boolean isFlagcreationmode() {
		return flagcreationmode;
	}

	public void setFlagcreationmode(boolean flagcreationmode) {
		this.flagcreationmode = flagcreationmode;
	}

	public String getObjecttype() {
		return objecttype;
	}

	public void setObjecttype(String objecttype) {
		this.objecttype = objecttype;
	}

	public String getObjectphase() {
		return objectphase;
	}

	public void setObjectphase(String objectphase) {
		this.objectphase = objectphase;
	}

	public String getObjectstatus() {
		return objectstatus;
	}

	public void setObjectstatus(String objectstatus) {
		this.objectstatus = objectstatus;
	}

	public String getPrcode() {
		return prcode;
	}

	public void setPrcode(String prcode) {
		this.prcode = prcode;
	}

	public int getPrioritylevel() {
		return prioritylevel;
	}

	public void setPrioritylevel(int prioritylevel) {
		this.prioritylevel = prioritylevel;
	}


	
	
}
