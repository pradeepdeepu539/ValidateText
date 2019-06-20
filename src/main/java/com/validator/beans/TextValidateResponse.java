package com.validator.beans;

import java.io.Serializable;

public class TextValidateResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private T result;
	private int responseCode;
	private String responseMessage;
	
	public TextValidateResponse(){
		this(TextValidateResponseCodes.SUCCESS.getCode(),TextValidateResponseCodes.SUCCESS.getMessage());
	}

	public TextValidateResponse(int respCode, String respMsg) {
		this.responseCode=respCode;
		this.responseMessage=respMsg;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
