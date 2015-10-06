package com.inventario.service.response;

import java.util.List;

import com.inventario.bean.ProductoBean;

public class ProductoListResponse extends CommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProductoBean> listaProductos;
	public List<ProductoBean> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<ProductoBean> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
}
