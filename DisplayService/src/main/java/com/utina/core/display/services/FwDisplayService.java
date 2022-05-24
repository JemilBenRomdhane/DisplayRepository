package com.utina.core.display.services;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;

import com.techlending.core.framework.shared.bean.AbstractResponse;
import com.techlending.core.framework.shared.bean.ResultModel;
import com.techlending.core.framework.shared.bean.UserCredentiel;
import com.utina.core.display.bean.BuildInfo;
import com.utina.core.display.bean.CompDisplayResponse;
import com.utina.core.display.bean.ParPagComFilteringResponse;
import com.utina.core.display.bean.ParPagComponentResponse;
import com.utina.core.display.bean.ParPagFilteringResponse;
import com.utina.core.display.bean.ParPageListResponse;
import com.utina.core.display.bean.ParPageRequest;
import com.utina.core.display.bean.ParPageResponse;
import com.utina.core.display.client.AuthenticationServiceClient;
import com.utina.core.display.entity.ParPagComFiltering;
import com.utina.core.display.entity.ParPagComponent;
import com.utina.core.display.entity.ParPagComponentLabel;
import com.utina.core.display.entity.ParPagFiltering;
import com.utina.core.display.entity.ParPage;
import com.utina.core.display.repository.PageListRepository;
import com.utina.core.display.repository.PageRepository;
import com.utina.core.display.repository.ParPagComponentLabelRepository;
import com.utina.core.display.repository.SqlFunctionRepository;

import sun.security.util.Debug;

@Service
public class FwDisplayService {

	
	 @Autowired
	 private PageListRepository pageListRepository;
	 
	 
	 @Autowired
	 private PageRepository pageRepository;
	 
	 @Autowired
	 private ParPagComponentLabelRepository compLabelRepository;
	 @Autowired
	 private SqlFunctionRepository sqlFunctionRepository;
	 
	 @Autowired
		private AuthenticationServiceClient authenticationService;
	 
	 @Autowired
	 BuildProperties buildProperties;
	 
	 
	 
	 /***********************************************************Read From file  *******************************************************/


	 public String  readFile(String fileName) {
	 	String res = "";
	     File file = new File (fileName);
	 	try {
	 		
	 		BufferedReader br = new BufferedReader(new FileReader( fileName) );
	 		String line;
	 		
	 		while ((line = br.readLine())  != null ) {
	 			res = res +" * "+line+"\n";
	 		}

	 		
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	 	return  res;
	 	

	 }


	 /*********************************************************** BuildInfo And RealseNote : *******************************************************/


	 public BuildInfo getBuildingInfo () {
	 	
	 	String Note = readFile("ReleaseNote.txt");
	 	
	 	if (Note == "") {Note = "Release Note Is Empty";}
	 	
	 	BuildInfo buildInfo  = new BuildInfo();
	 	
	 	buildInfo.setName(buildProperties.getName());
	 	buildInfo.setTime(buildProperties.getTime());
	 	buildInfo.setVersion(buildProperties.getVersion());
	 	buildInfo.setReleaseNote(Note);
	 	
	 	return(buildInfo);
	 	

	 	}
	 
	 
	 public AbstractResponse<?,ParPageListResponse> getParPageList(String pagcode,String paglabel) {
	
		 
		  // Retrieve Pages

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
				   
		   try {	 	        
	        
			   List<ParPageListResponse> pages = pageListRepository.getParPageList(pagcode, paglabel, currentUser.getLancode());
			   
	        
	        if (pages.size()==0) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(5L, "DISPLAY", currentUser.getLancode()) + "(" + pagcode + "," + paglabel + ")");

	   	
	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	                
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(pages);
	      	 resp.setDescription("");
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(200L, "GLOBAL", currentUser.getLancode()));
	    
	      	 
	      	 return resp;
	        
	  }catch (Exception e) {
		   	 resp.setCode("500");
	       	 resp.setData(null);
	       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

	       	 resp.setList(null);
	    
	       	 
	       	 return resp;
	       	   
	   }
	

		 
	 }
	 

	 public AbstractResponse<?,ParPageListResponse> getLandingPageList(String pagcode,String paglabel) {
		  // Retrieve Pages

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
				   
				   
		   try {	 	        
	        
			   List<ParPageListResponse> pages = pageListRepository.getLandingPageList(pagcode, paglabel, currentUser.getLancode());
			   
	        
	        if (pages.size()==0) {
	        	
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(5L, "DISPLAY", currentUser.getLancode()) + "(" + pagcode + "," + paglabel + ")");	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	                
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(pages);
	      	 resp.setDescription("");
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(200L, "GLOBAL", currentUser.getLancode()));
	    
	      	 
	      	 return resp;
	        
	  }catch (Exception e) {
		  
		   	 resp.setCode("500");
	       	 resp.setData(null);
	       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

	       	 resp.setList(null);
	    
	       	 
	       	 return resp;
	       	   
	   }
	

		 
	 }
	 

	 
	 public AbstractResponse<ParPageResponse,?> createPage (ParPageRequest pageRequest) {
	 
		  AbstractResponse resp=new AbstractResponse();
		   
		  ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
				   
		   
		   try {	 	        
	        
			   ParPage pageCheck = pageRepository.findPageByPagcode(pageRequest.getPagcode());
			   
	        
	        if (pageCheck!=null) {
	        	 resp.setCode("201");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(7L, "DISPLAY", currentUser.getLancode()) + "(" + pageRequest.getPagcode() + ")");

	   	
	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        ParPage page=new ParPage();
	        
	        page.setPagcode(pageRequest.getPagcode());
	        page.setPagicon(pageRequest.getPagicon());
	        page.setPagmodule(pageRequest.getPagmodule());
	        page.setPagurl(pageRequest.getPagurl());
	        page.setFlaglanding(pageRequest.isFlaglanding());
	        
	        
	        pageRequest.getParPagComponents().forEach( compRequest -> {
	        	
	        	ParPagComponent c = new ParPagComponent();
	        	
	        	c.setComcode(compRequest.getComcode());
	        	c.setComformat(compRequest.getComformat());
	        	c.setComrequired(compRequest.getComrequired());
	        	c.setComstyle(compRequest.getComstyle());
	        	c.setComtype(compRequest.getComtype());
	        	page.addParPagComponent(c);
	        });
	        
	        // filters :
	        
        
	        pageRequest.getParPagFilterings().forEach( filterRequest -> {
	        	
	        	ParPagFiltering f = new ParPagFiltering();
	        	f.setFilterdescription(filterRequest.getFilterdescription());
	        	f.setMgid(filterRequest.getMgid());
	        	f.setUserid(filterRequest.getUserid());
	        	f.setUserrole(filterRequest.getUserrole());
	        	f.setFlagcreationmode(filterRequest.isFlagcreationmode());
	        	f.setObjecttype(filterRequest.getObjecttype());
	        	f.setObjectphase(filterRequest.getObjectphase());
	        	f.setObjectstatus(filterRequest.getObjectstatus());
	        	f.setPrcode(filterRequest.getPrcode());
	        	f.setPrioritylevel(filterRequest.getPrioritylevel());
	        	
	        	filterRequest.getParPagComFilterings().forEach(cfRequest -> {
	        		
	        		ParPagComFiltering cf = new ParPagComFiltering();
	        		cf.setComcode(cfRequest.getComcode());
	        		cf.setFlaghide(cfRequest.getFlaghide());
	        		cf.setFlagrequired(cfRequest.getFlagrequired());
	        		cf.setFlagdisabled(cfRequest.getFlagdisabled());
	        		
	        		f.addParPagComFiltering(cf);
	        		
	        	});
	        	
	        	page.addParPagFiltering(f);
	        	
	        });
	        
	        
	        
	        // save
	        try {
	        	pageRepository.saveAndFlush(page);
	        	// save PageLabel
	        	pageRepository.f_update_pagelabel(pageRequest.getPagcode(), currentUser.getLancode(), pageRequest.getPaglabel());
	        	// loop and save comp. Labels :
	        	pageRequest.getParPagComponents().forEach(comp -> {
	        
	        		String commessage="";
	        		if (comp.getCommessage()!=null) { commessage=comp.getCommessage();}
	        		
	        		String comhint="";
	        		if (comp.getComhint()!=null) { comhint=comp.getComhint();}
	        		
	        		String complaceholder="";
	        		if (comp.getComplaceholder()!=null) { complaceholder=comp.getComplaceholder();}
	        		
	        		String comlabel="";
	        		if (comp.getComlabel()!=null) { comlabel=comp.getComlabel();}
	        		
	        		pageRepository.f_update_pagecomponentlabel(pageRequest.getPagcode(), comp.getComcode(), currentUser.getLancode(),
	        				comlabel, complaceholder, comhint, commessage);

	        	});
	        	
	        	
	        	return getPageDetail(pageRequest.getPagcode());
	        	
	        } catch (Exception eSave) {
	          	 resp.setCode("500");
		       	 resp.setData(null);
		       	 resp.setDescription(eSave.getLocalizedMessage() + eSave.getCause());
		     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

		       	 resp.setList(null);
		
		       	 
		       	 return resp;
		       	   
	        	
	        }
		 
	        

			  }catch (Exception e) {
				   	 resp.setCode("500");
			       	 resp.setData(null);
			       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
			     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

			       	 resp.setList(null);
		
			       	 
			       	 return resp;
			       	   
			   }
			


		 
	 }


	 public AbstractResponse<ParPageResponse,?> updatePage (String pagcode,ParPageRequest pageRequest) {
		 
		  AbstractResponse resp=new AbstractResponse();
		   
		  ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   
		   try {	 	        
	        
			   ParPage page = pageRepository.findPageByPagcode(pageRequest.getPagcode());
			   
	        
	        if (page==null) {
	        	 resp.setCode("404");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(8L, "DISPLAY", currentUser.getLancode()) + "(" + pageRequest.getPagcode() + ")");

	   	
	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        
	        page.setPagcode(pageRequest.getPagcode());
	        page.setPagicon(pageRequest.getPagicon());
	        page.setPagmodule(pageRequest.getPagmodule());
	        page.setPagurl(pageRequest.getPagurl());
	        page.setFlaglanding(pageRequest.isFlaglanding());

	        page.getParPagComponents().clear();

	        pageRequest.getParPagComponents().forEach( compRequest -> {
	        	
	        	ParPagComponent c = new ParPagComponent();
	        	
	        	c.setComcode(compRequest.getComcode());
	        	c.setComformat(compRequest.getComformat());
	        	c.setComrequired(compRequest.getComrequired());
	        	c.setComstyle(compRequest.getComstyle());
	        	c.setComtype(compRequest.getComtype());

	        	page.addParPagComponent(c);
	        });
	        
	        // filters :
	        
	        page.getParPagFilterings().clear();
        
	        pageRequest.getParPagFilterings().forEach( filterRequest -> {
	        	
	        	ParPagFiltering f = new ParPagFiltering();
	        	f.setFilterdescription(filterRequest.getFilterdescription());
	        	f.setMgid(filterRequest.getMgid());
	        	f.setUserid(filterRequest.getUserid());
	        	f.setUserrole(filterRequest.getUserrole());
	        	f.setFlagcreationmode(filterRequest.isFlagcreationmode());
	        	f.setObjecttype(filterRequest.getObjecttype());
	        	f.setObjectphase(filterRequest.getObjectphase());
	        	f.setObjectstatus(filterRequest.getObjectstatus());
	        	f.setPrcode(filterRequest.getPrcode());
	        	f.setPrioritylevel(filterRequest.getPrioritylevel());
	        		        	
	        	filterRequest.getParPagComFilterings().forEach(cfRequest -> {
	        		
	        		ParPagComFiltering cf = new ParPagComFiltering();
	        		cf.setComcode(cfRequest.getComcode());
	        		cf.setFlaghide(cfRequest.getFlaghide());
	        		cf.setFlagrequired(cfRequest.getFlagrequired());
	        		cf.setFlagdisabled(cfRequest.getFlagdisabled());
	        		
	        		f.addParPagComFiltering(cf);
	        		
	        	});
	        	
	        	page.addParPagFiltering(f);
	        	
	        });

	        
	        
	        // save
	        try {
	        	pageRepository.saveAndFlush(page);
	        	// save PageLabel
	        	pageRepository.f_update_pagelabel(pageRequest.getPagcode(), currentUser.getLancode(), pageRequest.getPaglabel());
	        	// loop and save comp. Labels :
	        	pageRequest.getParPagComponents().forEach(comp -> {
	        		String commessage="";
	        		if (comp.getCommessage()!=null) { commessage=comp.getCommessage();}
	        		
	        		String comhint="";
	        		if (comp.getComhint()!=null) { comhint=comp.getComhint();}
	        		
	        		String complaceholder="";
	        		if (comp.getComplaceholder()!=null) { complaceholder=comp.getComplaceholder();}
	        		
	        		String comlabel="";
	        		if (comp.getComlabel()!=null) { 
	        		
	        			comlabel=comp.getComlabel();
	        		
	        		}
	        		
	        		pageRepository.f_update_pagecomponentlabel(pageRequest.getPagcode(), comp.getComcode(), currentUser.getLancode(),
	        				comlabel, complaceholder, comhint, commessage);
	        	});
	        	
	        	
	        	return getPageDetail(pageRequest.getPagcode());
	        	
	        } catch (Exception eSave) {
	          	 resp.setCode("500");
		       	 resp.setData(null);
		       	 resp.setDescription(eSave.getLocalizedMessage() + eSave.getCause());
		     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

		       	 resp.setList(null);
		
		       	 
		       	 return resp;
		       	   
	        	
	        }
		 
	        

			  }catch (Exception e) {
				   	 resp.setCode("500");
			       	 resp.setData(null);
			       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
			     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

			       	 resp.setList(null);
		
			       	 
			       	 return resp;
			       	   
			   }
			


		 
	 }

	 
	 public AbstractResponse<?,CompDisplayResponse> getPageDisplay(String pagcode,String entity,Long entityid) {
			
		 
		  // Retrieve Pages

		   AbstractResponse resp=new AbstractResponse();
		   
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
		   
			UserCredentiel currentUser = response.getData();
				   
		
		   
		   try {	 	        
	        
			   ParPage page = pageRepository.findPageByPagcode(pagcode);
			   
	        
	        if (page==null) {
	        	 resp.setCode("404");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(6L, "DISPLAY", currentUser.getLancode()) + "(" + pagcode + ")");

	   	
	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        List <CompDisplayResponse> list = new ArrayList<>();
	        page.getParPagComponents().forEach(comp -> {
	        	CompDisplayResponse compResp = new CompDisplayResponse();
	        	//
	        	ParPagComponentLabel compLabel = compLabelRepository.getComponentLabel(currentUser.getLancode(), pagcode, comp.getComcode());
	        	
	        	if (compLabel==null) {
	        		compLabel = compLabelRepository.getComponentLabel("EN", pagcode, comp.getComcode());
	        		if (compLabel!=null) {
	        			compLabel.setComhint("NOT TRANSLATED");
	        			compLabel.setComlabel("## " + compLabel.getComlabel());
	        		}
	        	}
	        	
	        	if (compLabel!=null) {
	        		compResp.setComcode(comp.getComcode());
	        		compResp.setComformat(comp.getComformat());
	        		compResp.setComhint(compLabel.getComhint());
	        		compResp.setComlabel(compLabel.getComlabel());
	        		compResp.setCommessage(compLabel.getCommessage());
	        		compResp.setComplaceholder(compLabel.getComplaceholder());
	        		compResp.setFlagrequired(comp.getComrequired());
	        		compResp.setFlaghide(false);
	        		compResp.setFlagdisabled(false);
	        		compResp.setComstyle(comp.getComstyle());
	        		compResp.setComtype(comp.getComtype());
	        		
	        	} else {
	        		compResp.setComcode(comp.getComcode());
	        		compResp.setComformat(comp.getComformat());
	        		compResp.setComhint(comp.getComcode());
	        		compResp.setComlabel(comp.getComcode());
	        		compResp.setCommessage(comp.getComcode());
	        		compResp.setComplaceholder(comp.getComcode());
	        		compResp.setFlagrequired(comp.getComrequired());
	        		compResp.setFlaghide(false);
	        		compResp.setFlagdisabled(false);
	        		compResp.setComstyle(comp.getComstyle());
	        		compResp.setComtype(comp.getComtype());
	        	}
	        	
	        	
	        	list.add(compResp);
	        });
	        
	       // check Filters :
	        Long mgid=currentUser.getMgid();
	        Long userid=currentUser.getId();
	        String userrole=currentUser.getUserrole();
	        
	        String prcode="";
	        String objecttype="";
	        String objectphase="";
	        String objectstatus="";
	        boolean flagcreationmode=false;
	        boolean skipCheckEntity = false;
	        int prioritylevel=1;
	        
	        if (entity!=null && !entity.isBlank()) {
	        	if (entityid!=null && entityid!=0) {
	        		flagcreationmode=false;
		        	objecttype=sqlFunctionRepository.GetObjectType(entity, entityid);
		        	objectphase=sqlFunctionRepository.GetObjectPhase(entity, entityid);
		        	objectstatus=sqlFunctionRepository.GetObjectStatus(entity, entityid);
		        	if (entity.equals("PROPOSAL") || entity.equals("CONTRACT")) {
		        		prcode=sqlFunctionRepository.GetContractPrcode(entityid);
		        		
		        	}
	        	} else {
	        		// no ID :
	        		flagcreationmode=true;
	        	}
	        } else {
	        	// no entity :
	        	skipCheckEntity=true;
	        }
	        
	        final boolean fskipCheckEntity=skipCheckEntity;
	        final boolean fflagcreationmode=flagcreationmode;
	        final String fprcode=prcode;
	        final String fobjecttype=objecttype;
	        final String fobjectphase=objectphase;
	        final String fobjectstatus=objectstatus;
	        
	        page.getParPagFilterings().forEach(filter -> {
	        
		        Long lmgid=filter.getMgid();
		        Long luserid=filter.getUserid();
		        String luserrole=filter.getUserrole();
	        	
	        	// check UserRole
	        	// check Userid
	        	// check mgid:
	        	Boolean isApplicable=false;
	        	
	        	if (lmgid==null || lmgid==0 || lmgid==mgid) {
	        		// lmgid=0 : all MG Companies :
		        	isApplicable=true;
	        	}
	        	
	        	
	        	if (isApplicable && (luserrole==null || luserrole.equals("ALL") || luserrole.equals(userrole))) {
	        		isApplicable=true;
	        	} else {isApplicable=false;}
	        	
	        	if (isApplicable && (luserid==null || luserid==0 || luserid==userid)) {
	        		// luserid=0 : all Users
		        	isApplicable=true;
	        	} else {isApplicable=false;}
	        	        	
	        	if (isApplicable && !fskipCheckEntity) {
	        		if (fflagcreationmode) {
	        			if (filter.isFlagcreationmode()) {
	        				isApplicable=true;
	        			} else {isApplicable=false;}
	        			
	        		} else {
	        			if (filter.isFlagcreationmode()==false) {
	        				isApplicable=true;
	        			} else {isApplicable=false;}
	        		}
	        		
	        	}
	        	
	        	if (isApplicable) {
	        				// prcode :
			        		if (!fprcode.isBlank()) {
			        			if (filter.getPrcode()==null || filter.getPrcode().isBlank() || filter.getPrcode().equals("ALL")) {
			        				isApplicable=true;
			        			} else {
				        			if (filter.getPrcode().contains(fprcode)) {
				        				isApplicable=true;
				        			} else {isApplicable=false;}
			        			}
			        		}
			        		// objecttype :
			        		if (isApplicable && !fobjecttype.isBlank()) {
			        			if (filter.getObjecttype()==null || filter.getObjecttype().isBlank() || filter.getObjecttype().equals("ALL")) {
			        				isApplicable=true;
			        			} else {
				        			if (filter.getObjecttype().contains(fobjecttype)) {
				        				isApplicable=true;
				        			} else {isApplicable=false;}
			        			}
			        		}
			        		// objectphase :
			        		if (isApplicable && !fobjectphase.isBlank()) {
			        			if (filter.getObjectphase()==null || filter.getObjectphase().isBlank() || filter.getObjectphase().equals("ALL")) {
			        				isApplicable=true;
			        			} else {
				        			if (filter.getObjectphase().contains(fobjectphase)) {
				        				isApplicable=true;
				        			} else {isApplicable=false;}
			        			}
			        		}

			        		// objectstatus :
			        		if (isApplicable && !fobjectstatus.isBlank()) {
			        			if (filter.getObjectstatus()==null || filter.getObjectstatus().isBlank() || filter.getObjectstatus().equals("ALL")) {
			        				isApplicable=true;
			        			} else {
				        			if (!filter.getObjectstatus().contains(fobjectstatus)) {
				        				isApplicable=false;
				        			}
			        			}
			        		}
	        		
	        	}
	        	
	        	if (isApplicable) {
			        	filter.getParPagComFilterings().forEach(filterComp -> {
				        				        	
			        		//find in list and set flagRequired and flagHide
			        		String lcomcode=filterComp.getComcode();
			        		
			        		int index=-1;
			        		
			        		for(int i = 0; i<list.size(); i++){
			        		    if(list.get(i).getComcode().equals(lcomcode)){
			        		      index=i;
			        		      break;
			        		    }
			        		  }
			        				
			        		if (index>=0) {
			        				list.get(index).setFlaghide(filterComp.getFlaghide());
			        				list.get(index).setFlagrequired(filterComp.getFlagrequired());
			        				list.get(index).setFlagdisabled(filterComp.getFlagdisabled());
			        		
			        		}
			        		
			        	});
			        	
	        	} // end is applicable
	        	
	        	
	        	
	        });
	        
	        
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(list);
	      	 resp.setDescription("");
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(200L, "GLOBAL", currentUser.getLancode()));
	    
	      	 
	      	 return resp;
	        
	  }catch (Exception e) {
		   	 resp.setCode("500");
	       	 resp.setData(null);
	       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

	       	 resp.setList(null);
	    
	       	 
	       	 return resp;
	       	   
	   }
	

		 
	 }
	 

	 public AbstractResponse<ParPageResponse,?> getPageDetail(String pagcode) {
			
		 
		  // Retrieve Pages

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
				   
		   
		   try {	 	        
	        
			   ParPage page = pageRepository.findPageByPagcode(pagcode);
			   
	        
	        if (page==null) {
	        	 resp.setCode("404");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(6L, "DISPLAY", currentUser.getLancode()) + "(" + pagcode + ")");

	   	
	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        // pageLabel
	        // comLabelInfo
	        //Filtering : username/rolecode
	        //comFiltering : complabel
	        ParPageResponse pageResp = new ParPageResponse();
	        pageResp.setPagcode(pagcode);
	        pageResp.setPagicon(page.getPagicon());
	        pageResp.setPaglabel(sqlFunctionRepository.f_getparpagelabel(pagcode, currentUser.getLancode()));
	        pageResp.setPagmodule(page.getPagmodule());
	        pageResp.setPagurl(page.getPagurl());
	        
	        List<ParPagComponentResponse> pageCompResp=new ArrayList<>();
	        
	        page.getParPagComponents().forEach(comp -> {
	        	ParPagComponentResponse compResp = new ParPagComponentResponse();
	        	//
	        	ParPagComponentLabel compLabel = compLabelRepository.getComponentLabel(currentUser.getLancode(), pagcode, comp.getComcode());
	        	
	        	if (compLabel==null) {
	        		compLabel = compLabelRepository.getComponentLabel("EN", pagcode, comp.getComcode());
	        	}
	        	
	        	if (compLabel!=null) {
	        		compResp.setComcode(comp.getComcode());
	        		compResp.setComid(comp.getComid());
	        		compResp.setComformat(comp.getComformat());
	        		compResp.setComhint(compLabel.getComhint());
	        		compResp.setComlabel(compLabel.getComlabel());
	        		compResp.setCommessage(compLabel.getCommessage());
	        		compResp.setComplaceholder(compLabel.getComplaceholder());
	        		compResp.setComrequired(comp.getComrequired());
	        		compResp.setComstyle(comp.getComstyle());
	        		compResp.setComtype(comp.getComtype());
	        		
	        	} else {
	        		compResp.setComid(comp.getComid());
	        		compResp.setComcode(comp.getComcode());
	        		compResp.setComformat(comp.getComformat());
	        		compResp.setComhint(comp.getComcode());
	        		compResp.setComlabel(comp.getComcode());
	        		compResp.setCommessage(comp.getComcode());
	        		compResp.setComplaceholder(comp.getComcode());
	        		compResp.setComrequired(comp.getComrequired());
	        		compResp.setComstyle(comp.getComstyle());
	        		compResp.setComtype(comp.getComtype());
	        	}
	        	
	        	
	        	pageCompResp.add(compResp);
	        });
	        
	        pageResp.setParPagComponents(pageCompResp);
	       
	        List<ParPagFilteringResponse> pageFilteringResp=new ArrayList<>();
	        page.getParPagFilterings().forEach(filter -> {
	        	ParPagFilteringResponse filterResp = new ParPagFilteringResponse();
	        	filterResp.setFilterdescription(filter.getFilterdescription());
	        	filterResp.setFilterid(filter.getFilterid());
	        	filterResp.setMgid(filter.getMgid());
	        	String rolelabel="";
	        	if (filter.getUserrole()!=null) {
	        		rolelabel=sqlFunctionRepository.GetParListLabel("UROLE", filter.getUserrole(), currentUser.getLancode());
	        	}
	        	filterResp.setRolelabel(rolelabel);
	        	filterResp.setUserid(filter.getUserid());
	        	String username="";
	        	
	        	if (filter.getUserid()!=null) {
	        		username=sqlFunctionRepository.GetUsername(filter.getUserid());
	        		
	        	}
	        	
	        	filterResp.setUsername(username);
	        	filterResp.setUserrole(filter.getUserrole());
	        	filterResp.setFlagcreationmode(filter.isFlagcreationmode());
	        	filterResp.setObjectphase(filter.getObjectphase());
	        	filterResp.setObjectstatus(filter.getObjectstatus());
	        	filterResp.setObjecttype(filter.getObjecttype());
	        	filterResp.setPrcode(filter.getPrcode());
	        	filterResp.setPrioritylevel(filter.getPrioritylevel());
	        	
		        List<ParPagComFilteringResponse> pageComFilteringResp=new ArrayList<>();

	        	filter.getParPagComFilterings().forEach(filterComp -> {
		        	ParPagComFilteringResponse filterComResp = new ParPagComFilteringResponse();
		        	///
		        	filterComResp.setComcode(filterComp.getComcode());
		        	String comlabel="";
		        	if (filterComp.getComcode()!=null) {
		        		comlabel=sqlFunctionRepository.f_getparpagcomponentlabel(pagcode, filterComp.getComcode(), currentUser.getLancode());
		        	}
		        	filterComResp.setComlabel(comlabel);
		        	filterComResp.setFlaghide(filterComp.getFlaghide());
		        	filterComResp.setFlagrequired(filterComp.getFlagrequired());
		        	filterComResp.setFlagdisabled(filterComp.getFlagdisabled());
		        	filterComResp.setComfilterid(filterComp.getComfilterid());
	        		pageComFilteringResp.add(filterComResp);
	        		
	        	});
	        	
	        	filterResp.setParPagComFilterings(pageComFilteringResp);
	        	
	        	pageFilteringResp.add(filterResp);
	        	
	        });
	        
	        pageResp.setParPagFilterings(pageFilteringResp);
	       
	        
	        resp.setCode("200");
	      	 resp.setData(pageResp);
	      	 resp.setList(null);
	      	 resp.setDescription("");
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(200L, "GLOBAL", currentUser.getLancode()));
	    
	      	 
	      	 return resp;
	        
	  }catch (Exception e) {
		  
		   	 resp.setCode("500");
	       	 resp.setData(null);
	       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

	       	 resp.setList(null);
	    
	       	 
	       	 return resp;
	       	   
	   }
	

		 
	 }
	 

	 
	 
}

