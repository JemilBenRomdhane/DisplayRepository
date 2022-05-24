package com.techlending.core.framework.shared.bean;



public class ResultModel {
    private int code;
    private String message;
    private String token;
    private UserCredentiel data;

 

public ResultModel() {
		super();
	}


    public ResultModel(ResultStatus status, String message, UserCredentiel data) {
        this.code = status.getCode();
        this.message = message != null ? message : status.getMessage();
        this.data = data;
    }
    
    public ResultModel(ResultStatus status,UserCredentiel data) {
        this.code = status.getCode();
        this.data = data;
    }

    public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public UserCredentiel getData() {
		return data;
	}


	public void setData(UserCredentiel data) {
		this.data = data;
	}


	public ResultModel(UserCredentiel data, String token) {
      //  this.code = status.getCode();
      //  this.message = message != null ? message : status.getMessage();
        this.data = data;
        this.token = token;
    }

 
//    public static ResultModel _202(UserCredentiel data) {
//        return new ResultModel(ResultStatus.SUCCESS, data);
//    }
    
    public static ResultModel _200(String token, UserCredentiel data) {
        return new ResultModel(data,token);
    }


    public static ResultModel _403(String message, UserCredentiel data) {
        return new ResultModel(ResultStatus.FORBIDDEN, message, data);
    }

    public static ResultModel _404(String message, UserCredentiel data) {
        return new ResultModel(ResultStatus.NOT_FOUND, message, data);
    }

    public static ResultModel _400(String message, UserCredentiel data) {
        return new ResultModel(ResultStatus.BAD_REQUEST, message, data);
    }

    public static ResultModel _500(String message, UserCredentiel data) {
        return new ResultModel(ResultStatus.INTERNAL_SERVER_ERROR, message, data);
    }

    public static ResultModel unauthorized(String message, UserCredentiel data) {
        return new ResultModel(ResultStatus.UNAUTHORIZED, message, data);
    }

}