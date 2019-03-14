package com.ffi.financial.endpoint;

import java.io.Serializable;
import java.util.Map;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> responseObject;

	public Map<String, Object> getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Map<String, Object> responseObject) {
		this.responseObject = responseObject;
	}
}
