package com.inventario.service.response;

import java.io.Serializable;

public class CommonResponse implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codResponse;
	private String msgResponse;
	public String getCodResponse() {
		return codResponse;
	}
	public void setCodResponse(String codResponse) {
		this.codResponse = codResponse;
	}
	public String getMsgResponse() {
		return msgResponse;
	}
	public void setMsgResponse(String msgResponse) {
		this.msgResponse = msgResponse;
	}
}
