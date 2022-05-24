package com.utina.core.display.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.hibernate.annotations.Immutable;

@NamedStoredProcedureQuery(name = "f_getctproduct", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ictrid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectreference", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getObjecttype", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),  
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectreference", type = String.class) })
@NamedStoredProcedureQuery(name = "f_getObjectphase", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),  
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectreference", type = String.class) })
@NamedStoredProcedureQuery(name = "f_getObjectstatus", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),  
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectreference", type = String.class) })


@NamedStoredProcedureQuery(name = "f_getparpagcomponentlabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ipagcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "icomcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pagelabel", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getparpagelabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ipagcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pagelabel", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getmessage", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "imsgid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "imodule", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "msglabel", type = String.class) })

@NamedStoredProcedureQuery(name = "f_gettpname", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "itpid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tpname", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getPaymentsRefSI", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "isiid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "payref", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getPaymentsRefCI", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iciid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "payref", type = String.class) })


@NamedStoredProcedureQuery(name = "f_getUsername", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "username", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getParListLabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iparcode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iparvalue", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "parlistlabel", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getObjectReference", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),  
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectreference", type = String.class) })

@NamedStoredProcedureQuery(name = "f_getObjectID", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),  
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectref", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "objectid", type = Long.class) })


@NamedStoredProcedureQuery(name = "f_getprocedurelabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iproccode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "label", type = String.class) })

@NamedStoredProcedureQuery(name = "f_gettasklabel", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "itaskid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ilancode", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "label", type = String.class) })


@NamedStoredProcedureQuery(name = "f_rule_application", procedureName = "plus1inout", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Long.class),  
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "ientity", type = String.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientityid", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "iobject", type = String.class),
			  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iobjectid", type = Long.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = boolean.class) })


@NamedStoredProcedureQuery(name = "f_add_pardocument_to_entity", procedureName = "plus1inout", parameters = {
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "imodule", type = String.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "ientityid", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.IN, name = "iuserid", type = Long.class),
  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "nb", type = Integer.class) })

@NamedStoredProcedureQuery(name = "f_getDataProcidDByTaskID", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "entityid", type = Integer.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "entitytype", type = String.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "itaskid", type = Integer.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "procid", type = long.class) })

@NamedStoredProcedureQuery(name = "f_getDataProcTaskIDByTaskID", procedureName = "plus1inout", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "entityid", type = Integer.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "entitytype", type = String.class),
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "itaskid", type = Integer.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "proctaskid", type = long.class) })

@NamedStoredProcedureQuery(name = "f_getfuncode", procedureName = "plus1inout", parameters = {
		   @StoredProcedureParameter(mode = ParameterMode.IN, name = "itaskid", type = Integer.class),
		   @StoredProcedureParameter(mode = ParameterMode.OUT, name = "funcode", type = String.class) })





@Entity (name="vparam")
@Immutable
public class SqlFunction {

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
