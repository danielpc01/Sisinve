package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventario.bean.AreaBean;
import com.inventario.bean.TiendaBean;
import com.inventario.negocio.UbicacionNegocio;
import com.inventario.service.response.AreaListResponse;
import com.inventario.service.response.DepartamentoListResponse;
import com.inventario.service.response.TiendaListResponse;
import com.inventario.util.enums.ResponseService;

@Controller
@RequestMapping( value = "/ubicacion" )
public class UbicacionController {

	@Autowired
	private UbicacionNegocio ubicacionNego;
	
	
	@RequestMapping(value = "/departamentos", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DepartamentoListResponse getDepartamentos(){
		
		DepartamentoListResponse response= new DepartamentoListResponse();
		response.setListaDepartamento(ubicacionNego.getDepartamentos());
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		
		return response;
		
	}
	
	@RequestMapping(value = "/tiendas/{idDepartamento}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TiendaListResponse getTiendas(@PathVariable(value="idDepartamento") String idDepartamento){
		
		TiendaListResponse response= new TiendaListResponse();
		
		TiendaBean filtroBusq = new TiendaBean();
		filtroBusq.setIdDepa(idDepartamento);
		
		response.setListaTienda(ubicacionNego.getTiendas(filtroBusq));
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		return response;
		
	}
	
	@RequestMapping(value = "/areas/{idTienda}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AreaListResponse getAreas(@PathVariable(value="idTienda") String idTienda){
		
		AreaListResponse response= new AreaListResponse();
		
		AreaBean filtroBusq = new AreaBean();
		filtroBusq.setIdTienda(idTienda);
		
		response.setListaArea(ubicacionNego.getAreas(filtroBusq));
		response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
		response.setMsgResponse(ResponseService.EXITO.getMensaje());
		return response;
		
	}
}
