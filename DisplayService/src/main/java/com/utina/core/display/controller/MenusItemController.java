package com.utina.core.display.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlending.core.framework.shared.bean.AbstractResponse;
import com.utina.core.display.bean.MenusDisplayResponse;
import com.utina.core.display.bean.MenusItemRequest;
import com.utina.core.display.bean.MenusRequest;
import com.utina.core.display.bean.MenusResponse;
import com.utina.core.display.bean.MenusRolesRequest;
import com.utina.core.display.bean.MenusTreeResponse;
import com.utina.core.display.bean.MenusUsersRequest;
import com.utina.core.display.bean.UserResponse;
import com.utina.core.display.entity.ParList;
import com.utina.core.display.entity.ViewMenus;
import com.utina.core.display.services.MenusItemService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
@Api("Menus Display API Description")

public class MenusItemController {

@Autowired
private MenusItemService MenusItemService;


@GetMapping("/myMenus")
public AbstractResponse<?,MenusDisplayResponse> getCurrentUserMenu() {

    return MenusItemService.getCurrentUserMenu();
}

@GetMapping("/menus/{menuid}")
public AbstractResponse<MenusResponse,?> getMenuDetail(@PathVariable Long menuid
	) {

    return MenusItemService.getMenuDetail(menuid);
    
}

@GetMapping("/menusTree/{menuid}")
public AbstractResponse<MenusTreeResponse,?> getMenuTreeDetail(@PathVariable Long menuid
	) {

    return MenusItemService.getMenuTreeDetail(menuid);
    
}

@PostMapping("/menus/{menuid}/status/{status}")
public AbstractResponse<MenusResponse,?> updateMenuStatus(
		@PathVariable Long menuid,
        @PathVariable String status) {

    return MenusItemService.updateMenuStatus(menuid, status);
    
}


@GetMapping("/getUsersByCriteria")
public AbstractResponse<?,UserResponse> getUsersByCriteria(
        @RequestParam(value = "username") String username,
        @RequestParam(value = "name") String name) {

    return MenusItemService.getUsersByCriteria(username, name);
    
    
}

@GetMapping("/getParList")
public AbstractResponse<?,ParList> getParList(String parcode) {

    return MenusItemService.getParList(parcode);
    		
    
    
}

@GetMapping("/menus")
public AbstractResponse<?,ViewMenus> getMenusByLabel(String menulabel) {

    return MenusItemService.getMenusByLabel( menulabel);
    		
    
    
}

@PostMapping("/menus")
public AbstractResponse<MenusResponse, ?> createMenus(@Valid@RequestBody MenusRequest menusRequest) {

	return MenusItemService.createMenu(menusRequest);

}


@PutMapping("/menus/{menuid}")
public AbstractResponse<MenusResponse, ?> updateMenus(@PathVariable Long menuid,
		@Valid @RequestBody MenusRequest menusRequest) {

	return MenusItemService.updateMenu(menuid,menusRequest);

}

//*********************************** Menusitem ************************************************

@PostMapping("/menus/menuitems")
public AbstractResponse<MenusResponse,?> addMenusitem(@RequestBody MenusItemRequest menuRequest ,
		  @RequestParam(value = "isBefore") Boolean isBefore,
		  @RequestParam(value = "isAfter") Boolean isAfter,
		  @RequestParam(value = "isChild")Boolean isChild ,
		  @RequestParam(value = "pitemid")Long pitemid  ){
	return MenusItemService.addMenusitem(menuRequest, isBefore, isAfter, isChild, pitemid);
}

@PutMapping("/menus/menuitems/{pitemid}")
public AbstractResponse<MenusResponse,?> UpdateMenusitem(@RequestBody MenusItemRequest menuRequest , @PathVariable Long pitemid  ) {
	return MenusItemService.UpdateMenusitem(menuRequest, pitemid);
}

@DeleteMapping("/menus/menuitems/{pitemid}")
public AbstractResponse<MenusResponse,?> deleteMenusitem( @PathVariable Long pitemid  ) {
	return MenusItemService.deleteMenusitem(pitemid);
}

@PutMapping("/menus/menuitems/{pitemid}/{pitemidTarget}")
public AbstractResponse<MenusResponse,?> MoveMenusitem( @PathVariable Long pitemid ,  @PathVariable Long pitemidTarget  ,  @RequestParam(value = "isChild") Boolean isChild ) {
	return MenusItemService.MoveMenusitem(pitemid, pitemidTarget, isChild);
	
}

//********************************* menusroles *************************************************

@PostMapping("/menus/menusroles")
public AbstractResponse<MenusResponse,?> addMenusroles(@RequestBody MenusRolesRequest menuRequest) {
	return MenusItemService.addMenusroles(menuRequest);
}

@DeleteMapping("/menus/menusroles/{associd}")
public AbstractResponse<MenusResponse,?> removeMenusroles(@PathVariable Long associd) {
	return MenusItemService.removeMenusroles(associd);
}

@GetMapping("/menus/menusroles/{menuid}")
public AbstractResponse<MenusResponse,?> getListMenusroles(@PathVariable Long menuid) {
	return MenusItemService.getListMenusroles(menuid);
}

//******************************** menususers **************************************************

@PostMapping("/menus/menususers")
public AbstractResponse<MenusResponse,?> addMenususers(@RequestBody MenusUsersRequest menuRequest) {
	return MenusItemService.addMenususers(menuRequest);
}

@DeleteMapping("/menus/menususers/{associd}")
public AbstractResponse<MenusResponse,?> removeMenususers(@PathVariable Long associd ) {
	return MenusItemService.removeMenususers(associd);
}

@GetMapping("/menus/menususers/{menuid}")
public AbstractResponse<MenusResponse,?> getListMenususers(@PathVariable Long menuid) {
	return MenusItemService.getListMenususers(menuid);	
	
}

/*
public AbstractResponse<MenusResponse,?> moveBeforeOrAfter(@RequestParam(name = "pitemId") Long pitemId,
															@RequestParam(name = "menuId") Long menuId,
															@RequestParam(name = "targetId") Long targetId, 
															@RequestParam(name = "isBefore") Boolean isBefore,
															@RequestParam(name = "isAfter") Boolean isAfter ){

	return MenusItemService.moveBeforeOrAfter(pitemId, menuId, targetId, isBefore, isAfter);
}
*/

}
