package com.utina.core.display.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techlending.core.framework.shared.bean.AbstractResponse;
import com.utina.core.display.bean.BuildInfo;
import com.utina.core.display.bean.CompDisplayResponse;
import com.utina.core.display.bean.ParPageListResponse;
import com.utina.core.display.bean.ParPageRequest;
import com.utina.core.display.bean.ParPageResponse;
import com.utina.core.display.services.FwDisplayService;

import io.swagger.annotations.Api;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
@Api("Framework Display API Description")

public class FwDisplayController {

	
	
@Autowired
private FwDisplayService FwDisplayService;


@Value("${apiVersion}")
private String apiVersion;

@GetMapping("/version")
public String version () {
	return "DisplayService - release " + apiVersion;
}


@GetMapping("/getBuildingInfo")
public BuildInfo getBuildingInfo () {
	return FwDisplayService.getBuildingInfo();
	}


@GetMapping("/myPageDisplay")
public AbstractResponse<?,CompDisplayResponse> getCurrentPageDisplay(
		            @RequestParam(value = "pagcode") String pagcode,
		            @RequestParam(value = "entity",defaultValue = "") String entity ,
		            @RequestParam(value = "entityid",defaultValue = "0") Long entityid) {

		        return FwDisplayService.getPageDisplay(pagcode, entity, entityid);
		    }
	
@GetMapping("/pages")
public AbstractResponse<?, ParPageListResponse> getPagesByCriteria(String pagcode,String paglabel) {

    return FwDisplayService.getParPageList(pagcode, paglabel);
    
}

@GetMapping("/pages/landing")
public AbstractResponse<?, ParPageListResponse> getLandingPagesByCriteria(String pagcode,String paglabel) {

    return FwDisplayService.getLandingPageList(pagcode, paglabel);
    
}

@GetMapping("/pages/{pagcode}")
public AbstractResponse<ParPageResponse,?> getPageDetail(@PathVariable String pagcode) {

    return FwDisplayService.getPageDetail(pagcode);
    		
    
}

@PostMapping("/pages")
public AbstractResponse<ParPageResponse,?> createPage(@Valid@RequestBody ParPageRequest pageRequest) {

    return FwDisplayService.createPage(pageRequest);
    
}

@PutMapping("/pages/{pagcode}")
public AbstractResponse<ParPageResponse,?> updatePage(@PathVariable String pagcode,@Valid@RequestBody ParPageRequest pageRequest) {

    return FwDisplayService.updatePage(pagcode,pageRequest);
    
}

}
