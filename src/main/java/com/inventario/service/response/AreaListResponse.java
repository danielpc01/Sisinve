package com.inventario.service.response;

import java.util.List;

import com.inventario.bean.AreaBean;

public class AreaListResponse extends CommonResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AreaBean> listaArea;
	public List<AreaBean> getListaArea() {
		return listaArea;
	}
	public void setListaArea(List<AreaBean> listaArea) {
		this.listaArea = listaArea;
	}
	

}
