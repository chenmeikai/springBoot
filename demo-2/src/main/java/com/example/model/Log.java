package com.example.model;

import java.util.Date;

public class Log {
	
	private Long id;
	
	private String clientIp;
	
	private String uri;
	
	private String type;
	
	private String method;
	
	private String paramData;
	
	private String sessionId;
	
	private Date reqeustTime;
	
	private Date returnTime;
	
	private String returnData;
	
	private String statuCode;
	
	private Integer timeConsuming;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getReqeustTime() {
		return reqeustTime;
	}

	public void setReqeustTime(Date reqeustTime) {
		this.reqeustTime = reqeustTime;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
    
    
	public String getReturnData() {
		return returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	public String getStatuCode() {
		return statuCode;
	}

	public void setStatuCode(String statuCode) {
		this.statuCode = statuCode;
	}

	public Integer getTimeConsuming() {
		return timeConsuming;
	}

	public void setTimeConsuming(Integer timeConsuming) {
		this.timeConsuming = timeConsuming;
	}

	
	
	

}
