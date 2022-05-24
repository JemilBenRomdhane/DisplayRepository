package com.techlending.core.framework.security;

import javax.servlet.http.HttpServletRequest;

public class SecurityComplienceProvider {
	
	public static boolean checkCustomSecurityCompliance(HttpServletRequest request , String gatewaysecret) {
  	  
 	   boolean iSecurityComplience = false;
 	   String iDevStage = request.getHeader("Dev-Stage");
 	   
 	   if(null != iDevStage && iDevStage.equalsIgnoreCase("true")) {
 		   return true;
 	   }
 	   
 	  String iBatchStages = request.getHeader("Batch-Stage");
	   
	   if(null != iBatchStages && iBatchStages.equalsIgnoreCase("true")) {
		   return true;
	   }
 	   
 	   String iCheckGateway = request.getHeader("GATEWAY-CHECK");
 	   String iSignedGateway = request.getHeader("GATEWAY-SIGN");
 	   if(null != iCheckGateway && iCheckGateway.equalsIgnoreCase("true")) {
 		   if(null != iSignedGateway  && iSignedGateway.equalsIgnoreCase(gatewaysecret)) {
 			   return true;
 		   }
  	   }
   	   
  	  return iSecurityComplience;
  }

}
