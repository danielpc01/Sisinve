package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventario.bean.ProductoBean;
import com.inventario.negocio.ProductoNegocio;
import com.inventario.service.request.ProductoRequest;
import com.inventario.service.response.ProductoListResponse;
import com.inventario.service.response.ProductoResponse;
import com.inventario.util.enums.ResponseService;

@Controller
@RequestMapping( value = "/producto" )
public class ProductoController {

	@Autowired
	private ProductoNegocio productoNegocio;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductoResponse saveProducto(@RequestBody ProductoRequest request){
		ProductoResponse response= new ProductoResponse();
		ProductoBean producto=request.getProducto();
		
		producto =productoNegocio.saveProducto(producto);
		
		response.setProducto(producto);
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		
		return response;
	}
	
	@RequestMapping(value = "/get/{idProducto}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductoResponse getProducto(@PathVariable(value="idProducto") String idProducto){
		
		ProductoResponse response= new ProductoResponse();
		
		ProductoBean filtroBusq = new ProductoBean();
		filtroBusq.setId(idProducto);
		
		response.setProducto(productoNegocio.getProducto(filtroBusq));
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		return response;
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ProductoListResponse getProductos(){
		
		ProductoListResponse response= new ProductoListResponse();
		
		response.setListaProductos(productoNegocio.getProductos(null));
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		return response;
		
	}
}
