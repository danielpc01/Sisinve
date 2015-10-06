package com.inventario.service.response;

import java.util.List;

import com.inventario.bean.DepartamentoBean;

public class DepartamentoListResponse extends CommonResponse{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DepartamentoBean> listaDepartamento;
	
	public List<DepartamentoBean> getListaDepartamento() {
		return listaDepartamento;
	}
	public void setListaDepartamento(List<DepartamentoBean> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}
	
	
}
