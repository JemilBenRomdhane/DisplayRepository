package com.utina.core.display.client;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import feign.RequestInterceptor;
import feign.RequestTemplate;
public class FeignClientInterceptor implements RequestInterceptor {
	 private static final String AUTHORIZATION_HEADER="Authorization";
	 private static final String Devstage = "Dev-stage";
	  private static final String TOKEN_TYPE = "Bearer";
	  private static final String CheckGateWay = "GATEWAY-CHECK";
	@Override
	public void apply(RequestTemplate template) {
		// TODO Auto-generated method stub
		template.header(AUTHORIZATION_HEADER, getBearerTokenHeader() );
	}
	
      public String getBearerTokenHeader() {
		
	
			
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
	
		}
}
