package com.techlending.core.framework.shared.bean;

import java.util.List;
import io.swagger.annotations.*;

public class AbstractResponse<Data,T> {

   
	//private String apiVersion; // to get form application.properties
	
	private String code; // to set 
    
	
	private String message; 
	
	
    private String description;
	
	
	
	
	private Data data;
	
	
	private List<T> list;
    

    public AbstractResponse() {

    }

    public AbstractResponse(Data data,List<T> list, String code,String message,
    					String description) {
        this.data = data;
        this.list=list;
    
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

	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

    
    
}

