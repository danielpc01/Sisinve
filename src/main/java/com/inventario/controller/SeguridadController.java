package com.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inventario.bean.UsuarioBean;
import com.inventario.negocio.UsuarioNegocio;
import com.inventario.service.request.UsuarioRequest;
import com.inventario.service.response.UsuarioResponse;
import com.inventario.util.enums.ResponseService;

@Controller
@RequestMapping( value = "/seguridad" )
public class SeguridadController {

	
	@Autowired
	private UsuarioNegocio usuarioNegocio;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UsuarioResponse login(@RequestBody UsuarioRequest request){
		
		UsuarioResponse response= new UsuarioResponse();
		UsuarioBean usuRequest=request.getUsuario();
		UsuarioBean usuResponse=usuarioNegocio.getUsuario(usuRequest.getCodUsuario(), usuRequest.getPassUsuario());
		response.setUsuario(usuResponse);
		
		if(usuResponse!=null){
			response.setCodResponse(String.valueOf(ResponseService.EXITO.getCodigo()));
			response.setMsgResponse(ResponseService.EXITO.getMensaje());
		}else{
			response.setCodResponse(String.valueOf(ResponseService.ERROR.getCodigo()));
			response.setMsgResponse(ResponseService.ERROR.getMensaje());
			
		}
		
		
		return response;
		
	}
	
}
