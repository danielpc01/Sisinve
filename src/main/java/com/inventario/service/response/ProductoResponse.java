package com.inventario.service.response;

import com.inventario.bean.ProductoBean;

public class ProductoResponse extends CommonResponse  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductoBean producto;
	public ProductoBean getProducto() {
		return producto;
	}
	public void setProducto(ProductoBean producto) {
		this.producto = producto;
	}
	
}
