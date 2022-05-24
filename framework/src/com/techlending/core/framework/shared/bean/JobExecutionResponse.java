package com.techlending.core.framework.shared.bean;

import java.util.List;
import io.swagger.annotations.*;

public class JobExecutionResponse {

   
	@ApiModelProperty(
			  value = "Return code : 200 - OK, 204 : Exec OK, but No Data Found, Others : Error",
			  name = "code",
			  dataType = "String",
			  example = "200")
	private String code; // to set 
    
	@ApiModelProperty(
			  value = "Message, if Error, else = Success",
			  name = "message",
			  dataType = "String",
			  example = "Success, Error")

	private String message; 
	
	@ApiModelProperty(
			  value = "Description of Error, if any",
			  name = "description",
			  dataType = "String",
			  example = "No data found with ID = &ID")
    
	private String description;
	
	private String outputfile;
	
	private String logfile;
	
	private String errorfile;
	
	private Long jobid;
	
	private String servicename;    

    public JobExecutionResponse() {

    }

    public JobExecutionResponse( String code,String message,
    					String description,String logfile,String outputfile,Long jobid, String servicename) {
        
    	this.logfile = logfile;
        this.outputfile=outputfile;
        this.jobid=jobid;
        this.servicename=servicename;
        
        this.code = code;
        this.message = message;
        this.description = description;
    
    }

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOutputfile() {
		return outputfile;
	}

	public void setOutputfile(String outputfile) {
		this.outputfile = outputfile;
	}

	public String getLogfile() {
		return logfile;
	}

	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}

	public Long getJobid() {
		return jobid;
	}

	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getErrorfile() {
		return errorfile;
	}

	public void setErrorfile(String errorfile) {
		this.errorfile = errorfile;
	}


	
}

