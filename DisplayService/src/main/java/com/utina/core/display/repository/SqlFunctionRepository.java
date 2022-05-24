package com.utina.core.display.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.entity.SqlFunction;


public interface SqlFunctionRepository extends JpaRepository<SqlFunction, Long> {
	
	@Procedure("f_getUsername")
    String GetUsername( @Param("userid") Long userid);
	
	@Procedure("f_getparpagcomponentlabel")
	String f_getparpagcomponentlabel(@Param("ipagcode") String ipagcode,@Param("icomcode") String icomcode,@Param("ilancode") String ilancode);
	
	@Procedure("f_getparpagelabel")
	String f_getparpagelabel(@Param("ipagcode") String ipagcode,@Param("ilancode") String ilancode);
	
	@Procedure("f_getmessage")
	String f_getmessage(@Param("imsgid") Long imsgid,@Param("imodule") String imodule,@Param("ilancode") String ilancode);
	
	@Procedure("f_add_pardocument_to_entity")
    Integer AddPardocumentToEntity( @Param("imodule") String imodule,@Param("ientityid") Long ientityid,@Param("iuserid") Long iuserid);
	
	
	@Procedure("f_rule_application")
    boolean VerifyApplicationRule(@Param("iuserid") Long iuserid, @Param("ientity") String ientity,@Param("ientityid") Long ientityid, @Param("iobject") String iobject,@Param("iobjectid") Long iobjectid);

	
	@Procedure("f_getprocedurelabel")
    String GetProcedureLabel( @Param("proccode") String proccode,@Param("lancode") String lancode);
	

	@Procedure("f_getPaymentsRefSI")
    String GetPaymentsRefSI( @Param("siid") Long siid);
	
	@Procedure("f_getPaymentsRefCI")
    String GetPaymentsRefCI( @Param("ciid") Long ciid);
	
	@Procedure("f_gettasklabel")
    String GetTaskLabel( @Param("taskid") Long taskid,@Param("lancode") String lancode);
	
	@Procedure("f_getdataproctaskidbytaskid")
    Long GetProcTaskIDByTaskID( @Param("entityid") Long entityid,@Param("entitytype") String entitytype,@Param("itaskid") Long itaskid);

	@Procedure("f_getdataprocidbytaskid")
    Long GetProcIDByTaskID( @Param("entityid") Long entityid,@Param("entitytype") String entitytype,@Param("itaskid") Long itaskid);
	
	@Procedure("f_getfuncode")
    String GetFunCode( @Param("taskid") Long taskid);
	
	@Procedure("f_getParListLabel")
    String GetParListLabel( @Param("parcode") String parcode,@Param("parvalue") String parvalue,@Param("lancode") String lancode);

	@Procedure("f_getctproduct")
    String GetContractPrcode( @Param("ictrid") Long ictrid);
	
	@Procedure("f_getobjectreference")
    String GetObjectReference( @Param("ientity") String ientity,@Param("iobjectid") Long iobjectif);

	@Procedure("f_getobjecttype")
    String GetObjectType( @Param("ientity") String ientity,@Param("iobjectid") Long iobjectif);

	@Procedure("f_getobjectphase")
    String GetObjectPhase( @Param("ientity") String ientity,@Param("iobjectid") Long iobjectif);

	@Procedure("f_getobjectstatus")
    String GetObjectStatus( @Param("ientity") String ientity,@Param("iobjectid") Long iobjectif);

	@Procedure("f_getobjectid")
    Long GetObjectID( @Param("ientity") String ientity,@Param("iobjectref") String iobjectref);

	@Procedure("f_gettpname")
    String GetTPName( @Param("itpid") Long itpid);

}
