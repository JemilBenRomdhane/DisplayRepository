package com.utina.core.display.entity;



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


@Entity
@Table(name = "parpagfiltering")
public class ParPagFiltering  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long filterid;
	
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
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
 	@JoinColumn(name = "pagcode", nullable = false)
	
 	private ParPage page;

 	public ParPagFiltering() {

    }

    public ParPagFiltering(String userrole,Long mgid,Long userid, String filterdescription) {

    	this.filterdescription=filterdescription;
    	this.mgid=mgid;
    	this.userid=userid;
    	this.userrole=userrole;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filterid == null) ? 0 : filterid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParPagFiltering other = (ParPagFiltering) obj;
		if (filterid == null) {
			if (other.filterid != null)
				return false;
		} else if (!filterid.equals(other.filterid))
			return false;
		return true;
	}

	//Links to Components Filtering
    @OneToMany(
            mappedBy = "parPagFiltering",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Size(min = 0, max = 100)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 100)
    private List<ParPagComFiltering> ParPagComFilterings = new ArrayList<>();


	public void addParPagComFiltering(ParPagComFiltering parPagComFiltering) {
		ParPagComFilterings.add(parPagComFiltering);
		parPagComFiltering.setParPagFiltering(this);
	    }

	public void removeParPagComFiltering(ParPagComFiltering parPagComFiltering) {
		ParPagComFilterings.remove(parPagComFiltering);
		parPagComFiltering.setParPagFiltering(null);
	    }

///
	
	
	
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


	public void setPage(ParPage page) {
		this.page = page;
	}

	public List<ParPagComFiltering> getParPagComFilterings() {
		return ParPagComFilterings;
	}

	public void setParPagComFilterings(List<ParPagComFiltering> parPagComFilterings) {
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

	public ParPage getPage() {
		return page;
	}

	
	
	
}
