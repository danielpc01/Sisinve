package com.inventario.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.bean.ProductoBean;

@Service
public interface ProductoNegocio {

	public ProductoBean saveProducto(ProductoBean producto);
	public List<ProductoBean> getProductos(ProductoBean filtroBusq);
	public ProductoBean getProducto(ProductoBean filtroBusq);
}
