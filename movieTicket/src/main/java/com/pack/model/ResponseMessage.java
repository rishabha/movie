package com.pack.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {

	
	private StatusMessage status;
	private ErrorMessage error;
	private Object data;
	
	
	
	public ResponseMessage(){}


	public StatusMessage getStatus() {
		return status;
	}


	public void setStatus(StatusMessage status) {
		this.status = status;
	}


	public ErrorMessage getError() {
		return error;
	}


	public void setError(ErrorMessage error) {
		this.error = error;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	

	

	


	
	
	
	
}
