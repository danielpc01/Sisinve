package com.inventario.service.response;

import java.util.List;

import com.inventario.bean.TiendaBean;

public class TiendaListResponse extends CommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TiendaBean> listaTienda;

	public List<TiendaBean> getListaTienda() {
		return listaTienda;
	}

	public void setListaTienda(List<TiendaBean> listaTienda) {
		this.listaTienda = listaTienda;
	}
	
	
}
