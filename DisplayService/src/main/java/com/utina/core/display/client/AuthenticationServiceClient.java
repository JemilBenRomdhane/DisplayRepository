package com.utina.core.display.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techlending.core.framework.shared.bean.ResultModel;

import feign.Headers;


@FeignClient(name = "${name.webservice.login.authentification}", url = "${url.webservice.login.authentification}",configuration = FeignClientInterceptor.class)
public interface AuthenticationServiceClient {
	
	@RequestMapping(value = "/authenticateme", method = RequestMethod.POST)
	@Headers("Content-Type: application/json")
	@ResponseBody
	public ResultModel createAuthenticationToken ();
}


