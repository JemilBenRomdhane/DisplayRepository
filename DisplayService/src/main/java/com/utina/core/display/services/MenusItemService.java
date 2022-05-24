package com.utina.core.display.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.techlending.core.framework.shared.bean.AbstractResponse;
import com.techlending.core.framework.shared.bean.ResultModel;
import com.techlending.core.framework.shared.bean.UserCredentiel;
import com.utina.core.display.bean.MenusDisplayResponse;
import com.utina.core.display.bean.MenusItemRequest;
import com.utina.core.display.bean.MenusItemResponse;
import com.utina.core.display.bean.MenusItemTreeResponse;
import com.utina.core.display.bean.MenusRequest;
import com.utina.core.display.bean.MenusResponse;
import com.utina.core.display.bean.MenusRolesRequest;
import com.utina.core.display.bean.MenusRolesResponse;
import com.utina.core.display.bean.MenusTreeResponse;
import com.utina.core.display.bean.MenusUsersRequest;
import com.utina.core.display.bean.MenusUsersResponse;
import com.utina.core.display.bean.UserResponse;
import com.utina.core.display.client.AuthenticationServiceClient;
import com.utina.core.display.entity.Menus;
import com.utina.core.display.entity.MenusItem;
import com.utina.core.display.entity.MenusRoles;
import com.utina.core.display.entity.MenusUsers;
import com.utina.core.display.entity.ParList;
import com.utina.core.display.entity.Users;
import com.utina.core.display.entity.ViewMenus;
import com.utina.core.display.entity.ViewMenusItem;
import com.utina.core.display.entity.ViewParPage;
import com.utina.core.display.repository.MenusDisplayRepository;
import com.utina.core.display.repository.MenusRepository;
import com.utina.core.display.repository.MenusRolesRepository;
import com.utina.core.display.repository.MenusUsersRepository;
import com.utina.core.display.repository.ParListRepository;
import com.utina.core.display.repository.SqlFunctionRepository;
import com.utina.core.display.repository.UserRepository;
import com.utina.core.display.repository.ViewMenusItemRepository;
import com.utina.core.display.repository.ViewMenusRepository;
import com.utina.core.display.repository.ViewParPageRepository;



@Service
public class MenusItemService {
	
	 @Autowired
	 private MenusDisplayRepository MenusItemRepository;
	 
	 @Autowired
	 private MenusRepository menusRepository;
	
	 @Autowired
	 private SqlFunctionRepository sqlFunctionRepository;
		
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private ParListRepository parlistRepository;
	 
	 @Autowired
	 private ViewMenusRepository viewMenusRepository;
	 
	 @Autowired
	 private ViewMenusItemRepository viewMenusItemRepository;
	
	 @Autowired
	 private ViewParPageRepository viewParPageRepository;
	 
	 @Autowired
		private AuthenticationServiceClient authenticationService;
	 
	 
	 @Autowired
		private com.utina.core.display.repository.MenusItemRepository menusItemRepository;
	 
	 @Autowired
		private MenusRolesRepository menusRolesRepository;
	 
	 @Autowired
		private MenusUsersRepository menusUsersRepository;


	 
	 public AbstractResponse<?,UserResponse> getUsersByCriteria(String username,String name) {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   
		   try {	 	        
	        
			   List<Users> users = userRepository.findByUserByNameofUsername(username, name);
			   
	        
	        if (users.size()==0) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(2L, "DISPLAY", currentUser.getLancode()) + username + " - " + name);

   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        List<UserResponse> usersResp = new ArrayList<>();

	        users.forEach(u -> {
	        	UserResponse uresp = new UserResponse();
	        	uresp.setName(u.getName() + " " + u.getSurname());
	        	uresp.setUsername(u.getUsername());
	        	uresp.setUserid(u.getId());
	        	
	        	usersResp.add(uresp);
	        	
	        });
	        
	                
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(usersResp);
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
		 
	 
	 public AbstractResponse<?,ParList> getParList(String parcode) {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   try {	 	        
	        
			   List<ParList> param = parlistRepository.getListParList(parcode, currentUser.getLancode(), currentUser.getMgid());
			   
	        
	        if (param.size()==0) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(3L, "DISPLAY", currentUser.getLancode()));

	   	      	 return resp;
	   	          			        			
	        }
	        
	                
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(param);
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
		 

	 public AbstractResponse<?,ViewMenus> getMenusByLabel(String menuslabel) {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   
		   try {	 	        
	        
			   List<ViewMenus> menus = viewMenusRepository.getMenusByLabel(menuslabel);
			   
	        
	        if (menus.size()==0) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(4L, "DISPLAY", currentUser.getLancode()) + menuslabel);

	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	                
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(menus);
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
		 

	 public AbstractResponse<?,MenusDisplayResponse> getCurrentUserMenu() {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   try {	 	        
	        
			   List<MenusDisplayResponse> menusitemsdetail = MenusItemRepository.getCurrentUserMenu(currentUser.getId(),currentUser.getUserrole(),currentUser.getLancode());
			   if (menusitemsdetail.size()==0) {
				   menusitemsdetail = MenusItemRepository.getCurrentUserMenu(currentUser.getId(),currentUser.getUserrole(),"EN");
				   menusitemsdetail.forEach(e-> {
					   e.setItemlabel("## " + e.getItemlabel());
					   e.setPaglabel("## " + e.getPaglabel());
				   });
			   }
			   
			   List<MenusDisplayResponse> menusitemsHeader = MenusItemRepository.getCurrentUserHeaderMenu(currentUser.getId(),currentUser.getUserrole());

			   List<MenusDisplayResponse> menusitems = new ArrayList<MenusDisplayResponse>();
			   
			   menusitems.addAll(menusitemsHeader);
			   menusitems.addAll(menusitemsdetail);
			   
	        if (menusitems.size()==0) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(1L, "DISPLAY", currentUser.getLancode()) +currentUser.getUsername());

	   	      	 return resp;
	   	          			        			
	        }
	        
	        resp.setCode("200");
	      	 resp.setData(null);
	      	 resp.setList(menusitems);
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
	
 
	 public AbstractResponse<MenusResponse,?> getMenuDetail(Long menuid) {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   try {	 	        
	        
			   Menus menus=menusRepository.findMenuByMenuid(menuid);
			   
	        
	        if (menus==null) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(1L, "DISPLAY", currentUser.getLancode()) +menuid);

	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        // prepare menusResponse.
	        
	        MenusResponse menuResp = new MenusResponse();
	        
	        menuResp.setMenuid(menus.getMenuid());
	        menuResp.setMenudescription(menus.getMenudescription());
	        menuResp.setMenulabel(menus.getMenulabel());
	        menuResp.setMenustatus(menus.getMenustatus());
	        
	        String statusLabel="";
	        
	        try {
	        	statusLabel=sqlFunctionRepository.GetParListLabel("MENUSTAT", menus.getMenustatus(), currentUser.getLancode());
	        	
	        }catch (Exception e) {
	        	statusLabel=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+menus.getMenustatus();
	        }
	        
	        menuResp.setStatuslabel(statusLabel);
	        
	        // menusRoles :
	        
	        List <MenusRoles> menusRoles = menusRolesRepository.findByMenuid(menuid);
	        
	        if(menusRoles.size()>0) {
	        	
	        
	        
	        List<MenusRolesResponse> mrResponse = new ArrayList<>();
	        
	        	menusRoles.forEach(mr -> {
	        	MenusRolesResponse mrResp =new MenusRolesResponse();
	        	mrResp.setAssocid(mr.getAssocid());
	        	mrResp.setRolcode(mr.getRolcode());

		        String rolelabel="";
		        
		        try {
		        	rolelabel=sqlFunctionRepository.GetParListLabel("UROLE", mr.getRolcode(), currentUser.getLancode());
		        	
		        }catch (Exception e) {
		        	rolelabel=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+mr.getRolcode();
		        }

	        	mrResp.setRolelabel(rolelabel);
	        	
	        	mrResponse.add(mrResp);
	        	
	        });
	        
	        menuResp.setMenusRoles(mrResponse);
	        
	        }
	        
	        // menusUsers :
	        
	        List <MenusUsers> menusUsers =  menusUsersRepository.findByMenuid(menuid);
	        
	        if(menusUsers.size()>0) {
	 
	        List<MenusUsersResponse> muResponse = new ArrayList<>();
	        
	        	menusUsers.forEach(mu -> {
	        	MenusUsersResponse muResp =new MenusUsersResponse();
	        	muResp.setAssocid(mu.getAssocid());
	        	muResp.setUserid(mu.getUserid());

	        	String name="";
	        	String username="";
	        	
		        Users user =  userRepository.findByUserId(mu.getUserid());
		        
		        if (user==null) {
		        	name=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+ mu.getUserid();
		        	username=name;
		        	
		        } else {
		        	name=user.getName() + user.getSurname();
		        	username=user.getUsername();
		        }
		        
	        	muResp.setName(name);
	        	muResp.setUsername(username);
	        	
	        	muResponse.add(muResp);
	        	
	        });
	        
	        menuResp.setMenusUsers(muResponse);
	        
	        }
	        
	        // sort :
	        
//	        Comparator<MenusItem> compareById = (MenusItem o1, MenusItem o2) -> ((o1.getItemidparent()==null ? "00"+o1.getItemid().toString():"00"+o1.getItemidparent().toString())+(o1.getItemid().toString())).compareTo( o2.getItemidparent()==null ? "00"+o2.getItemid().toString() : "00"+o2.getItemidparent().toString()+ o2.getItemid().toString() );
	        
	        Comparator<MenusItem> compareById = (MenusItem o1, MenusItem o2) -> (o1.getItemidparent()==null ? o1.getItemid():o1.getItemidparent()).compareTo( o2.getItemidparent()==null ? o2.getItemid():o2.getItemidparent());

	        
	        List<MenusItem> menusItems = menusItemRepository.findByMenuid(menuid);
	        
	        if (menusItems.size()>0) {
	        
	        menusItems.sort(compareById);
	        
	        // menusItems :
	        List<MenusItemResponse> itemResponse = new ArrayList<>();
	        
	        menusItems.forEach(item -> {
	        	MenusItemResponse itemResp =new MenusItemResponse();
	        	
	        	itemResp.setItemid(item.getItemid());
	        	itemResp.setItemidparent(item.getItemidparent());
	        	itemResp.setItemlabel(item.getItemlabel());
	        	itemResp.setItemorder(item.getItemorder());
	        	itemResp.setPagcode(item.getPagcode());
	        	itemResp.setPitemid(item.getPitemid());
	        	itemResp.setPagparams(item.getPagparams());
	        	
	        	if (item.getPagcode()!=null && !item.getPagcode().isBlank()) {
	        		itemResp.setPaglabel(sqlFunctionRepository.f_getparpagelabel(item.getPagcode(), currentUser.getLancode()));
	        	} else {itemResp.setPaglabel("");}
	        	
	        	String pagurl="";
	        	
	        	ViewParPage page=viewParPageRepository.getParPage(item.getPagcode());
	        	
	        	if (page==null) {
	        		pagurl=""; //sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+ item.getPagcode();
	        	} else {
	        		
	        		pagurl=page.getPagurl();
	        	}
	        	
	        	itemResp.setPagurl(pagurl);
	        	
		        	        	
	        	itemResponse.add(itemResp);
	        	
	        });
	        
	        menuResp.setMenusItems(itemResponse);
	        
	        }
	        


	        // return Response: 
	        
	        resp.setCode("200");
	      	 resp.setData(menuResp);
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


	 public AbstractResponse<MenusTreeResponse,?> getMenuTreeDetail(Long menuid) {
	        
	     // Retrieve Menus

		   AbstractResponse resp=new AbstractResponse();
		   
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
		   try {	 	        
	        
			   Menus menus=menusRepository.findMenuByMenuid(menuid);
			   
	        
	        if (menus==null) {
	        	 resp.setCode("204");
	   	      	 resp.setData(null);
	   	      	 resp.setDescription("");
	   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(1L, "DISPLAY", currentUser.getLancode()) +menuid);

	   	      	 
	   	      	 return resp;
	   	          			        			
	        }
	        
	        // prepare menusResponse.
	        
	        MenusTreeResponse menuResp = new MenusTreeResponse();
	        
	        menuResp.setMenuid(menus.getMenuid());
	        menuResp.setMenudescription(menus.getMenudescription());
	        menuResp.setMenulabel(menus.getMenulabel());
	        menuResp.setMenustatus(menus.getMenustatus());
	        
	        String statusLabel="";
	        
	        try {
	        	statusLabel=sqlFunctionRepository.GetParListLabel("MENUSTAT", menus.getMenustatus(), currentUser.getLancode());
	        	
	        }catch (Exception e) {
	        	statusLabel=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+menus.getMenustatus();
	        }
	        
	        menuResp.setStatuslabel(statusLabel);
	        
	        // menusRoles :
	        List<MenusRolesResponse> mrResponse = new ArrayList<>();
	        
	        List <MenusRoles> menusRoles = menusRolesRepository.findByMenuid(menuid);
	        
	        if(menusRoles.size()>0) {
	        
	        
	        	menusRoles.forEach(mr -> {
	        	MenusRolesResponse mrResp =new MenusRolesResponse();
	        	mrResp.setAssocid(mr.getAssocid());
	        	mrResp.setRolcode(mr.getRolcode());

		        String rolelabel="";
		        
		        try {
		        	rolelabel=sqlFunctionRepository.GetParListLabel("UROLE", mr.getRolcode(), currentUser.getLancode());
		        	
		        }catch (Exception e) {
		        	rolelabel=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+mr.getRolcode();
		        }

	        	mrResp.setRolelabel(rolelabel);
	        	
	        	mrResponse.add(mrResp);
	        	
	        });
	        
	        menuResp.setMenusRoles(mrResponse);
	        
	        }
	        
	        // menusUsers :
	        List <MenusUsers> menusUsers =  menusUsersRepository.findByMenuid(menuid);
	        
	        if(menusUsers.size()>0) {
	        
	        List<MenusUsersResponse> muResponse = new ArrayList<>();
	        
	        //get MenusByMenuId
	        
	        	menusUsers.forEach(mu -> {
	        	MenusUsersResponse muResp =new MenusUsersResponse();
	        	muResp.setAssocid(mu.getAssocid());
	        	muResp.setUserid(mu.getUserid());

	        	String name="";
	        	String username="";
	        	
		        Users user =  userRepository.findByUserId(mu.getUserid());
		        
		        if (user==null) {
		        	name=sqlFunctionRepository.f_getmessage(404L, "SETUP", currentUser.getLancode())+ mu.getUserid();
		        	username=name;
		        	
		        } else {
		        	name=user.getName() + user.getSurname();
		        	username=user.getUsername();
		        }
		        
	        	muResp.setName(name);
	        	muResp.setUsername(username);
	        	
	        	muResponse.add(muResp);
	        	
	        });
	        
	        menuResp.setMenusUsers(muResponse);
	        
	        }
	        
	        // sort :
	        
	        List<ViewMenusItem> mainList=viewMenusItemRepository.getMenusItemChildren(menus.getMenuid(),0L);
	        
	        List<MenusItemTreeResponse> itemTreeResp=new ArrayList();
	        
	        mainList.forEach(l0 -> {
	        	
	        	MenusItemTreeResponse item0 = new MenusItemTreeResponse();
	        	
	        	item0.setItemid(l0.getItemid());
	        	item0.setItemid(l0.getItemid());
	        	item0.setItemidparent(l0.getItemidparent());
	        	item0.setItemlabel(l0.getItemlabel());
	        	item0.setItemorder(l0.getItemorder());
	        	item0.setPagcode(l0.getPagcode());
	        	item0.setPitemid(l0.getPitemid());
	        	item0.setPagparams(l0.getPagparams());
	        	item0.setTitle(l0.getItemid().toString() + " - " + l0.getItemlabel());
	        	item0.setMenuicon(l0.getMenuicon());
        		item0.setKey(l0.getItemid().toString());
        		
	        	if (l0.getPagcode()!=null && !l0.getPagcode().isBlank()) {
	        		item0.setPaglabel(sqlFunctionRepository.f_getparpagelabel(l0.getPagcode(), currentUser.getLancode()));
	        		item0.setCheckable(true);
	        		item0.setDisableCheckbox(false);
	        		item0.setDisabled(false);
	        		item0.setLeaf(true);
	        	
	        	
	        	
			        	ViewParPage page=viewParPageRepository.getParPage(l0.getPagcode());
			        	
			        	if (page!=null) {
			        		item0.setPagurl(page.getPagurl());
			        		item0.setIcon(page.getPagicon());
			        	}
	        	} else {
	        		item0.setLeaf(true);
	        	}
	        	// get childrens :
	        	
	        	List<MenusItemTreeResponse> child=getMenuChildren(menuid,l0.getItemid(),l0.getItemid().toString(),currentUser.getLancode());
	        	item0.setChildren(child);
	        	
	        	itemTreeResp.add(item0);
	        	
	        });

	        
	        menuResp.setMenusItems(itemTreeResp);
	        
	        


	        // return Response: 
	        
	        resp.setCode("200");
	      	 resp.setData(menuResp);
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



	 private List<MenusItemTreeResponse> getMenuChildren (Long menuid,Long pid, String key,String lancode) {
		 
		 List<ViewMenusItem> mainList=viewMenusItemRepository.getMenusItemChildren(menuid,pid);
	        
	        List<MenusItemTreeResponse> itemTreeResp=new ArrayList();
	        
	        mainList.forEach(l0 -> {
	        	
	        	MenusItemTreeResponse item0 = new MenusItemTreeResponse();
	        	
	        	item0.setItemid(l0.getItemid());
	        	item0.setItemid(l0.getItemid());
	        	item0.setItemidparent(l0.getItemidparent());
	        	item0.setItemlabel(l0.getItemlabel());
	        	item0.setItemorder(l0.getItemorder());
	        	item0.setPagcode(l0.getPagcode());
	        	item0.setPitemid(l0.getPitemid());
	        	item0.setPagparams(l0.getPagparams());
	        	item0.setTitle(key + "-"+l0.getItemid().toString() +" - " + l0.getItemlabel());
	        	item0.setMenuicon(l0.getMenuicon());
	        	
	        	if (item0.getItemidparent()==null) {
	        		// last node :
			        	if (l0.getPagcode()!=null && !l0.getPagcode().isBlank()) {
			        		item0.setPaglabel(sqlFunctionRepository.f_getparpagelabel(l0.getPagcode(), lancode));
			        		item0.setCheckable(true);
			        		item0.setDisableCheckbox(false);
			        		item0.setDisabled(false);
			        		
			        		item0.setKey(key + "-"+l0.getItemid().toString());
			        		item0.setLeaf(true);
			        	
			        	
			        	
					        	ViewParPage page=viewParPageRepository.getParPage(l0.getPagcode());
					        	
					        	if (page!=null) {
					        		item0.setPagurl(page.getPagurl());
					        		item0.setIcon(page.getPagicon());
					        	}
			        	}
			        	
			        	
	        	} else {
		        	List<MenusItemTreeResponse> child=getMenuChildren(menuid,l0.getItemid(),key + "-"+l0.getItemid().toString(),lancode);
		        	item0.setChildren(child);
		        	item0.setCheckable(true);
	        		item0.setDisableCheckbox(false);
	        		item0.setDisabled(false);
	        		
	        		item0.setKey(key + "-"+l0.getItemid().toString());
	        		item0.setLeaf(false);

	        	}
	        	
	        	
	        	itemTreeResp.add(item0);
	        	
	        });

	        
	        return itemTreeResp;
	        

		 
	 }
	 
	 
	 //********************************** Menu ********************************************
	 
	 public AbstractResponse<MenusResponse,?> createMenu(MenusRequest menuRequest) {

		   AbstractResponse resp=new AbstractResponse();
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();

			   try {	 	        
		        
				   Menus menus = new Menus();
				   
				   menus.setMenudescription(menuRequest.getMenudescription());
				   menus.setMenulabel(menuRequest.getMenulabel());
				   menus.setMenustatus("INIT");
	
				   try {
					   
					   menusRepository.saveAndFlush(menus);

					   return getMenuDetail(menus.getMenuid());


					   
				   } catch (Exception e) {
			        	 resp.setCode("500");
			   	      	 resp.setData(null);
			   	      	 resp.setDescription(e.getMessage());
			   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

		   	      	 
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
		 

	 public AbstractResponse<MenusResponse,?> updateMenu(Long menuid,MenusRequest menuRequest) {

		   AbstractResponse resp=new AbstractResponse();
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();

			   try {	 	        
		        
				   Menus menus = menusRepository.findMenuByMenuid(menuRequest.getMenuid());
				   
				   if (menus==null) {
					   
					 	 resp.setCode("404");
			   	      	 resp.setData(null);
			   	      	 resp.setDescription("");
			   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(204L, "DISPLAY", currentUser.getLancode()) + menuRequest.getMenuid());

		   	      	 
			   	      	 return resp;

				   }
				   
				   menus.setMenudescription(menuRequest.getMenudescription());
				   menus.setMenulabel(menuRequest.getMenulabel());
				   
	
				   
				   try {
					   
					   menusRepository.saveAndFlush(menus);

					   return getMenuDetail(menus.getMenuid());


					   
				   } catch (Exception e) {
			        	 resp.setCode("500");
			   	      	 resp.setData(null);
			   	      	 resp.setDescription(e.getMessage());
			   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

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
	
	 
	 public AbstractResponse<MenusResponse,?> updateMenuStatus(Long menuid,String status) {

		   AbstractResponse resp=new AbstractResponse();
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			   
			   try {	 	        
		        
				   Integer i=menusRepository.f_update_menustatus(menuid, status);
				   
		        
		        if (i==0) {
		        	 resp.setCode("500");
		   	      	 resp.setData(null);
		   	      	 resp.setDescription("f_update_menustatus (menuid,status) = (" + menuid + "," + status + ") - SQL return code=0");
		   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()) +menuid);

		   	      	 
		   	      	 return resp;
		   	          			        			
		        }
		        
		        return getMenuDetail(menuid);


				  }catch (Exception e) {
					   	 resp.setCode("500");
				       	 resp.setData(null);
				       	 resp.setDescription(e.getLocalizedMessage() + e.getCause());
				     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

				       	 resp.setList(null);
				       	 
				       	 return resp;
				       	   
				   }
				

			 
		 }

	 
	//********************************* Menusitem ********************************************* 
	 
	 
	 public AbstractResponse<MenusResponse,?> addMenusitem(MenusItemRequest menuRequest ,
																		 Boolean isBefore,
																		 Boolean isAfter,
																		 Boolean isChild ,
																		 Long pitemid  ) {

		   AbstractResponse resp=new AbstractResponse();
		   ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();

			   try {	 	        
		         
				   MenusItem menuItem = new MenusItem();
				   
				   Long id = menusItemRepository.getItemid(currentUser.getId());
				   
				   MenusItem ExItem = menusItemRepository.getMenusItem(pitemid);
				   
				   List <MenusItem> ExtMenuIt = menusItemRepository.findByallMenuid(menuRequest.getMenuid());
				   
				   
				   if (ExtMenuIt.size() == 0 ) {
					   
					   try {
						   
						   menuItem.setItemid(id);
						   menuItem.setPitemid(id);
						   
						   menuItem.setItemidparent(menuRequest.getItemidparent());
						   menuItem.setItemlabel(menuRequest.getItemlabel());
						   
						   menuItem.setItemorder(menuRequest.getItemorder());
						   
						   menuItem.setMenuicon(menuRequest.getMenuicon());
						   menuItem.setMenuid(menuRequest.getMenuid());
						   menuItem.setPagcode(menuRequest.getPagcode());
						   menuItem.setPagparams(menuRequest.getPagparams());
						   
						   menusItemRepository.save(menuItem); 
						   
						   	 resp.setCode("200");
				   	      	 resp.setData(menuItem);
				   	      	 resp.setList(getMenuTreeDetail(menuItem.getMenuid()).getList());
				   	      	 resp.setDescription("Menusitem Created with success ");
				   	     	 resp.setMessage("Menusitem Created with success ");

				   	      	 return resp;
						   
						   
						   
					   }catch (Exception e) {
						   
				        	 resp.setCode("500");
				   	      	 resp.setData(null);
				   	      	 resp.setList(null);
				   	      	 resp.setDescription(e.getMessage());
				   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

			   	      	 
				   	      	 return resp;
				   	          			        			
						   
						   
					   }
					   
					   
					   
					   
					   
				   }else {
					   
					   if (ExItem == null) {
						   resp.setCode("404");
				   	      	 resp.setData(menuItem);
				   	      	 resp.setDescription("pitemid Not Found to Insert ");
				   	     	 resp.setMessage("pitemid Not Found to Insert");

				   	      	 return resp;   
					   }
					   
					   
					   
				   }

	
				   try {
					   
					   if (isBefore) {
						   
						   menuItem.setItemid(id);
						   menuItem.setPitemid(id);
						   
						   menuItem.setItemidparent(menuRequest.getItemidparent());
						   menuItem.setItemlabel(menuRequest.getItemlabel());
						   
						   menuItem.setItemorder(ExItem.getItemorder());
						   
						   menuItem.setMenuicon(menuRequest.getMenuicon());
						   menuItem.setMenuid(menuRequest.getMenuid());
						   menuItem.setPagcode(menuRequest.getPagcode());
						   menuItem.setPagparams(menuRequest.getPagparams());
						   
						   menusItemRepository.save(menuItem);
						   
						   ExItem.setItemorder(ExItem.getItemorder()+1);
						   
						   menusItemRepository.save(ExItem);
						   
				   	      	
				   	      
				   	      List <MenusItem> items = menusItemRepository.findByMenuid(menuRequest.getMenuid());
						   
						   int index =  items.indexOf(menuItem);
						   
						   for (int i = index+2 ; i < items.size() ; i++) {
							   
							   items.get(i).setItemorder(items.get(i).getItemorder()+1);
							   
						   }
						   
						   menusItemRepository.saveAll(items);
						      
						   
					   }
					   
					   
					   else if (isAfter) {
						   
						   menuItem.setItemid(id);
						   menuItem.setPitemid(id);
						   
						   menuItem.setItemidparent(menuRequest.getItemidparent());
						   menuItem.setItemlabel(menuRequest.getItemlabel());
						   
						   menuItem.setItemorder(ExItem.getItemorder()+1);
						   
						   menuItem.setMenuicon(menuRequest.getMenuicon());
						   menuItem.setMenuid(menuRequest.getMenuid());
						   menuItem.setPagcode(menuRequest.getPagcode());
						   menuItem.setPagparams(menuRequest.getPagparams());
						   
						   menusItemRepository.save(menuItem);
						   
						   List <MenusItem> items = menusItemRepository.findByMenuid(menuRequest.getMenuid());
						   
						   int index =  items.indexOf(menuItem);
						   
						   for (int i = index+1 ; i < items.size() ; i++) {
							   
							   items.get(i).setItemorder(items.get(i).getItemorder()+1);
							   
						   }
						   
						   menusItemRepository.saveAll(items);
						   
						   
					   }
					   
					   
					   else if (isChild) {
						   
						   menuItem.setItemid(id);
						   menuItem.setPitemid(id);
						   
						   menuItem.setItemidparent(ExItem.getItemid());//Or pitemid ..
						   
						   menuItem.setItemlabel(menuRequest.getItemlabel());
						   menuItem.setItemorder(menuRequest.getItemorder());
						   menuItem.setMenuicon(menuRequest.getMenuicon());
						   menuItem.setMenuid(menuRequest.getMenuid());
						   menuItem.setPagcode(menuRequest.getPagcode());
						   menuItem.setPagparams(menuRequest.getPagparams());
						   
						   menusItemRepository.save(menuItem);
						   
					   }
					   
			        	 resp.setCode("200");
			   	      	 resp.setData(menuItem);
			   	      	 resp.setList(getMenuTreeDetail(ExItem.getMenuid()).getList());
			   	      	 resp.setDescription("Menusitem Created with success ");
			   	     	 resp.setMessage("Menusitem Created with success ");

			   	      	 return resp;
			   	          			  


					   
				   } catch (Exception e) {
			        	 resp.setCode("500");
			   	      	 resp.setData(null);
			   	      	 resp.setList(null);
			   	      	 resp.setDescription(e.getMessage());
			   	     	 resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));

		   	      	 
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
	 
	 /*public AbstractResponse<MenusResponse,?> moveBeforeOrAfter(Long pitemId,Long menuId,Long targetId, Boolean isBefore,Boolean isAfter ){
		 
			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
			MenusItem ExItem = menusItemRepository.getMenusItem(pitemId);
			
			MenusItem ExItemTarget = menusItemRepository.getMenusItem(targetId);
			
			if (ExItem == null || ExItemTarget == null) {
				resp.setCode("404");
				resp.setData(null);
				resp.setDescription("pitemid Not Found ");
				resp.setMessage("pitemid Not Found");
				
				return resp;   
				}
			
			if(isBefore == false && isAfter == false) {
				
				//AbstractResponse menuItemResponse= this.MoveMenusitem(pitemId, targetId, isAfter);
				//resp.setData(menuItemResponse.getData());
				resp.setMessage("menu moved to parent");
				return resp;
				
			}
			
			if (isBefore) {
				   
				   
					ExItem.setItemidparent(0L);
				   
					ExItem.setItemorder(ExItemTarget.getItemorder());;
			
				   
				   menusItemRepository.save(ExItem);
				   
				   ExItemTarget.setItemorder(ExItem.getItemorder()+1);
				   
				   menusItemRepository.save(ExItemTarget);
				   
		   	      	
		   	      
		   	      List <MenusItem> items = menusItemRepository.findByMenuid(menuId);
				   
				   int index =  items.indexOf(ExItemTarget.getItemorder());
				   
				   for (int i = index+1 ; i < items.size() ; i++) {
					   
					   items.get(i).setItemorder(items.get(i).getItemorder()+1);
					   
				   }
				   
				   menusItemRepository.saveAll(items);
				      
				   
			   }
			   
			   
			   else if (isAfter) {
				   
				  
				   
					ExItem.setItemidparent(0L);
					   
					ExItem.setItemorder(ExItemTarget.getItemorder()+1);;
				   
				   menusItemRepository.save(ExItem);
				   
				   List <MenusItem> items = menusItemRepository.findByMenuid(menuId);
				   
				   int index =  items.indexOf(ExItem);
				   
				   for (int i = index+1 ; i < items.size() ; i++) {
					   
					   items.get(i).setItemorder(items.get(i).getItemorder()+1);
					   
				   }
				   
				   menusItemRepository.saveAll(items);
				   
				   
			   }
			
			
			resp.setCode("200");
			resp.setData(ExItem);
			resp.setList(getMenuTreeDetail(ExItem.getMenuid()).getList());
			resp.setDescription("Menusitem Updated with success ");
			resp.setMessage("Menusitem Updated with success ");
			
			return resp;
			
			}catch(Exception e){
				
				resp.setCode("500");
				resp.setData(null);
				resp.setDescription(e.getMessage());
				resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
				
				
				return resp;
				
			}
			
			
		 
	 }*/
	
	 
	 public AbstractResponse<MenusResponse,?> UpdateMenusitem(MenusItemRequest menuRequest , Long pitemid  ) {

		AbstractResponse resp=new AbstractResponse();
		ResultModel response = authenticationService.createAuthenticationToken();
		UserCredentiel currentUser = response.getData();
		
		try {	 	        
		
		
		MenusItem ExItem = menusItemRepository.getMenusItem(pitemid);
		
		
		if (ExItem == null) {
		resp.setCode("404");
		resp.setData(null);
		resp.setDescription("pitemid Not Found to Update ");
		resp.setMessage("pitemid Not Found to Update");
		
		return resp;   
		}
		
		
		try {
		
		
		ExItem.setItemidparent(menuRequest.getItemidparent()); 
		ExItem.setItemlabel(menuRequest.getItemlabel());
		ExItem.setItemorder(menuRequest.getItemorder());
		ExItem.setMenuicon(menuRequest.getMenuicon());
		ExItem.setMenuid(menuRequest.getMenuid());
		ExItem.setPagcode(menuRequest.getPagcode());
		ExItem.setPagparams(menuRequest.getPagparams());
		
		menusItemRepository.save(ExItem);
		
	
		
		resp.setCode("200");
		resp.setData(ExItem);
		resp.setList(getMenuTreeDetail(ExItem.getMenuid()).getList());
		resp.setDescription("Menusitem Updated with success ");
		resp.setMessage("Menusitem Updated with success ");
		
		return resp;
		
		
		
		
		} catch (Exception e) {
		resp.setCode("500");
		resp.setData(null);
		resp.setDescription(e.getMessage());
		resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
		
		
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

	 
	 public AbstractResponse<MenusResponse,?> deleteMenusitem( Long pitemid  ) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
			MenusItem ExItem = menusItemRepository.getMenusItem(pitemid);
			
			
			if (ExItem == null) {
			resp.setCode("404");
			resp.setData(null);
			resp.setDescription("pitemid Not Found to Delete ");
			resp.setMessage("pitemid Not Found to Delete");
			
			return resp;   
			}
			
			
			try {
			
			
			menusItemRepository.delete(ExItem);
			
		
			
			resp.setCode("200");
			resp.setData(ExItem);
			 resp.setList(getMenuTreeDetail(ExItem.getMenuid()).getList());
			resp.setDescription("Menusitem Updated with success ");
			resp.setMessage("Menusitem Updated with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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

	 
	 public AbstractResponse<MenusResponse,?> MoveMenusitem( Long pitemid ,  Long pitemidTarget , Boolean isChild  ) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
			MenusItem ExItem = menusItemRepository.getMenusItem(pitemid);
			
			MenusItem ExItemtarget = menusItemRepository.getMenusItem(pitemidTarget);
			
			
			if (ExItem == null) {
			resp.setCode("404");
			resp.setData(null);
			resp.setDescription("pitemid Not Found to Move ");
			resp.setMessage("pitemid Not Found to Move");
			
			return resp;   
			}
			
			if (ExItemtarget == null) {
			resp.setCode("404");
			resp.setData(null);
			resp.setDescription("pitemidTarget Not Found to Move ");
			resp.setMessage("pitemidTarget Not Found to Move");
			
			return resp;   
			}
			
			
			try {
			
			if (isChild) {
				
				ExItem.setItemidparent(ExItemtarget.getItemid()); 
				
				menusItemRepository.save(ExItem);
				
			}else {
				
				
				
				ExItem.setItemidparent(0L);
				   
				ExItem.setItemorder(ExItemtarget.getItemorder());;
		
			   
			   menusItemRepository.save(ExItem);
			   
			   ExItemtarget.setItemorder(ExItem.getItemorder()+1);
			   
			   menusItemRepository.save(ExItemtarget);
			   
	   	      	
	   	      
	   	      List <MenusItem> items = menusItemRepository.findByMenuid(ExItem.getMenuid());
			   
			   int index =  items.indexOf(ExItemtarget.getItemorder());
			   
			   for (int i = index+1 ; i < items.size() ; i++) {
				   
				   items.get(i).setItemorder(items.get(i).getItemorder()+1);
				   
			   }
			   
			   menusItemRepository.saveAll(items);
				
				}

			
	
		   
		   
			
			resp.setCode("200");
			resp.setData(ExItem);
			resp.setList(getMenuTreeDetail(ExItem.getMenuid()).getList());
			resp.setDescription("Menusitem Updated with success ");
			resp.setMessage("Menusitem Updated with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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
	 
	 
	//********************************* Menusroles  ********************************************* 
	 
	 
	 public AbstractResponse<MenusResponse,?> addMenusroles(MenusRolesRequest menuRequest) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				MenusRoles menuRoles = new MenusRoles();

			
			
			try {
			
				menuRoles.setMenuid(menuRequest.getMenuid());
				menuRoles.setRolcode(menuRequest.getRolcode());
				
				menusRolesRepository.save(menuRoles);
		
			
			resp.setCode("200");
			resp.setData(menuRoles);
			 resp.setList(getMenuTreeDetail(menuRequest.getMenuid()).getList());
			resp.setDescription("MenuRoles Created with success ");
			resp.setMessage("MenuRoles Created with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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

	 
	 public AbstractResponse<MenusResponse,?> removeMenusroles(Long associd) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				MenusRoles menuRoles = menusRolesRepository.getMenusRolesById(associd);
				
				if (menuRoles == null) {
					
					resp.setCode("404");
					resp.setData(null);
					resp.setDescription("associd Not Found to delete ");
					resp.setMessage("associd Not Found to delete");
					
					return resp;  
				}

			
			
			try {
			
			menusRolesRepository.delete(menuRoles);
			
			resp.setCode("200");
			resp.setData(null);
			 resp.setList(getMenuTreeDetail(menuRoles.getMenuid()).getList());
			resp.setDescription("MenuRoles deleted with success ");
			resp.setMessage("MenuRoles deleted with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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
	
	 //GetList
	 
	 public AbstractResponse<MenusResponse,?> getListMenusroles(Long menuid) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				List <MenusRoles> menuRoles = menusRolesRepository.findByMenuid(menuid);
				
				if (menuRoles.size()==0) {
					
					resp.setCode("404");
					resp.setData(null);
					resp.setDescription("menuRoles List is empty for this menuid  ");
					resp.setMessage("menuRoles List is empty for this menuid  ");
					
					return resp;  
				}

			
			
			try {
			
			
			resp.setCode("200");
			resp.setData(null);
			resp.setList(menuRoles);
			resp.setDescription("MenuRoles fetched with success ");
			resp.setMessage("MenuRoles fetched with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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
	 
	 
	//********************************* MenusUsers  *********************************************  
	 
	 public AbstractResponse<MenusResponse,?> addMenususers(MenusUsersRequest menuRequest) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				MenusUsers MenusUsers = new MenusUsers();

			
			
			try {
			
				MenusUsers.setMenuid(menuRequest.getMenuid());
				MenusUsers.setUserid(menuRequest.getUserid());
				
				
				menusUsersRepository.save(MenusUsers);
				
				
		
			
			resp.setCode("200");
			resp.setData(MenusUsers);
			 resp.setList(getMenuTreeDetail(menuRequest.getMenuid()).getList());
			resp.setDescription("MenusUsers Created with success ");
			resp.setMessage("MenusUsers Created with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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

	 
	 public AbstractResponse<MenusResponse,?> removeMenususers(Long associd ) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				MenusUsers MenusUsers = menusUsersRepository.getMenusRolesById(associd);


			
			
			try {
			

				
				
				menusUsersRepository.delete(MenusUsers);
				
				
		
			
			resp.setCode("200");
			resp.setData(null);
			 resp.setList(getMenuTreeDetail(MenusUsers.getMenuid()).getList());
			resp.setDescription("MenusUsers Deleted with success ");
			resp.setMessage("MenusUsers Deleted with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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

	 //GetList 

	 public AbstractResponse<MenusResponse,?> getListMenususers(Long menuid) {

			AbstractResponse resp=new AbstractResponse();
			ResultModel response = authenticationService.createAuthenticationToken();
			UserCredentiel currentUser = response.getData();
			
			try {	 	        
			
			
				List <MenusUsers> MenusUsers = menusUsersRepository.findByMenuid(menuid);
				
				if (MenusUsers.size()==0) {
					
					resp.setCode("404");
					resp.setData(null);
					resp.setDescription("MenusUsers List is empty for this menuid  ");
					resp.setMessage("MenusUsers List is empty for this menuid  ");
					
					return resp;  
				}

			
			
			try {
			
			
			resp.setCode("200");
			resp.setData(null);
			resp.setList(MenusUsers);
			resp.setDescription("MenusUsers fetched with success ");
			resp.setMessage("MenusUsers fetched with success ");
			
			return resp;
			
			
			
			
			} catch (Exception e) {
			resp.setCode("500");
			resp.setData(null);
			resp.setDescription(e.getMessage());
			resp.setMessage(sqlFunctionRepository.f_getmessage(500L, "GLOBAL", currentUser.getLancode()));
			
			
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
	 
	 
	 
}

