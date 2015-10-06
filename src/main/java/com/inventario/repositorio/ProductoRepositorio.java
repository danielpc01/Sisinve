package com.inventario.repositorio;

import java.util.List;

import com.inventario.persistencia.Producto;

public interface ProductoRepositorio {

	public Producto saveProducto(Producto producto);
	
	public List<Producto> getProductos();
	
	public List<Producto> getProductos(int idArea);
	
	public Producto getProducto(int idProd);

}
