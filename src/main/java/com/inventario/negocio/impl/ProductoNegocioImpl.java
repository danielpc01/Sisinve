package com.inventario.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.bean.ProductoBean;
import com.inventario.negocio.ProductoNegocio;
import com.inventario.persistencia.Area;
import com.inventario.persistencia.Producto;
import com.inventario.persistencia.Usuario;
import com.inventario.repositorio.AreaRepositorio;
import com.inventario.repositorio.ProductoRepositorio;
import com.inventario.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class ProductoNegocioImpl implements ProductoNegocio{
	private static Logger LOG = Logger.getLogger(ProductoNegocioImpl.class);
	
	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	@Autowired
	private AreaRepositorio areaRepositorio;
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public ProductoBean saveProducto(ProductoBean productoBean) {
	
		Producto producto=new Producto();
		try {
			Area area=areaRepositorio.getArea(Integer.parseInt(productoBean.getIdArea()));
			Usuario usuario=usuarioRepositorio.getUsuarioPorId(Integer.parseInt(productoBean.getIdUsuario()));
			if(productoBean.getId()!=null){
				producto.setId(
						Integer.parseInt(productoBean.getId()));
					
			}
			
			
			producto.setCodigo(productoBean.getCodigo());
			producto.setDescripcion(productoBean.getDescripcion());
			producto.setUsuario(usuario);
			producto.setArea(area);
			
			Producto productoNew=productoRepositorio.saveProducto(producto);
			
			productoBean.setId(String.valueOf(productoNew.getId()));
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		}
		
		
		
		
		return productoBean;
	}


	public List<ProductoBean> getProductos(ProductoBean filtroBusq) {
		List<ProductoBean> lista=new ArrayList<ProductoBean>();
		try{
			List<Producto> productos=null;
			
			if(filtroBusq!=null){
				if(filtroBusq.getIdArea()!=null && !filtroBusq.getIdArea().trim().isEmpty()){
					productos=productoRepositorio.getProductos(Integer.parseInt(filtroBusq.getIdArea()));
				}
				
			}
			
			
			if(productos==null){
				productos=productoRepositorio.getProductos();
			}
			
			
			for(Producto prod:productos){
				ProductoBean producto=new ProductoBean();
				producto.setId(String.valueOf(prod.getId()));
				producto.setCodigo(prod.getCodigo());
				producto.setDescripcion(prod.getDescripcion());
				producto.setIdArea(String.valueOf(prod.getArea().getId()));
				producto.setIdUsuario(prod.getUsuario()!=null?
						String.valueOf(prod.getUsuario().getId()):null);
				lista.add(producto);
			}
		}catch(Exception e){
			
		}
		
		
		
		return lista;
	}


	public ProductoBean getProducto(ProductoBean filtroBusq) {
		ProductoBean producto=null;
		try{
			if(filtroBusq!=null){
				if(filtroBusq.getId()!=null && !filtroBusq.getId().trim().isEmpty()){
					Producto prod=productoRepositorio.getProducto(Integer.parseInt(filtroBusq.getId()));
					if(prod!=null){
						producto=new ProductoBean();
						producto.setId(String.valueOf(prod.getId()));
						producto.setCodigo(prod.getCodigo());
						producto.setDescripcion(prod.getDescripcion());
						producto.setIdArea(String.valueOf(prod.getArea().getId()));
						producto.setIdUsuario(
								prod.getUsuario()!=null?
								String.valueOf(prod.getUsuario().getId()):null);
						
					}
					
				}
			}
		}catch(Exception e){
			
		}
		
		
		
		
		return producto;
	}

}
