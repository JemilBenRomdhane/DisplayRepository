package com.utina.core.display.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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


@NamedStoredProcedureQuery(name = "f_update_pagelabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ipagcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ipaglabel", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ireturn", type = Integer.class) })


@NamedStoredProcedureQuery(name = "f_update_pagecomponentlabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ipagcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icomcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icomlabel", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icomplaceholder", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icomhint", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icommessage", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ireturn", type = Integer.class) })


@Entity
@Table(name = "parpage")
public class ParPage {

	@Id
	private String pagcode;
	
	//Components
    @OneToMany(
            mappedBy = "page",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Size(min = 0, max = 100)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 100)
    private List<ParPagComponent> ParPagComponents = new ArrayList<>();


	public void addParPagComponent(ParPagComponent parPagComponent) {
		ParPagComponents.add(parPagComponent);
		parPagComponent.setPage(this);
	    }

	public void removeParPagComponent(ParPagComponent parPagComponent) {
		ParPagComponents.remove(parPagComponent);
		parPagComponent.setPage(null);
	    }

	//Filtering
    @OneToMany(
            mappedBy = "page",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @Size(min = 0, max = 100)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 100)
    private List<ParPagFiltering> ParPagFilterings = new ArrayList<>();


	public void addParPagFiltering(ParPagFiltering parPagFiltering) {
		ParPagFilterings.add(parPagFiltering);
		parPagFiltering.setPage(this);
	    }

	public void removeParPagFiltering(ParPagFiltering parPagFiltering) {
		ParPagFilterings.remove(parPagFiltering);
		parPagFiltering.setPage(null);
	    }

	
	private String pagmodule;
	private String pagurl;
	private String pagicon;
	private boolean flaglanding;
	
	public String getPagcode() {
		return pagcode;
	}
	public void setPagcode(String pagcode) {
		this.pagcode = pagcode;
	}
	public String getPagmodule() {
		return pagmodule;
	}
	public void setPagmodule(String pagmodule) {
		this.pagmodule = pagmodule;
	}
	public String getPagurl() {
		return pagurl;
	}
	public void setPagurl(String pagurl) {
		this.pagurl = pagurl;
	}
	public String getPagicon() {
		return pagicon;
	}
	public void setPagicon(String pagicon) {
		this.pagicon = pagicon;
	}

	public List<ParPagComponent> getParPagComponents() {
		return ParPagComponents;
	}

	public void setParPagComponents(List<ParPagComponent> parPagComponents) {
		ParPagComponents = parPagComponents;
	}

	public List<ParPagFiltering> getParPagFilterings() {
		return ParPagFilterings;
	}

	public void setParPagFilterings(List<ParPagFiltering> parPagFilterings) {
		ParPagFilterings = parPagFilterings;
	}

	public boolean isFlaglanding() {
		return flaglanding;
	}

	public void setFlaglanding(boolean flaglanding) {
		this.flaglanding = flaglanding;
	}
	
		
}
