package com.utina.core.display.bean;



import java.util.ArrayList;
import java.util.List;


public class ParPagFilteringRequest  {

	private String userrole;
	private Long mgid;
	private Long userid;
	private String filterdescription;
	private boolean flagcreationmode;
	private String objecttype;
	private String objectphase;
	private String objectstatus;
	private String prcode;
	private int prioritylevel;
	
    private List<ParPagComFilteringRequest> ParPagComFilterings = new ArrayList<>();

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

	public List<ParPagComFilteringRequest> getParPagComFilterings() {
		return ParPagComFilterings;
	}

	public void setParPagComFilterings(List<ParPagComFilteringRequest> parPagComFilterings) {
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
