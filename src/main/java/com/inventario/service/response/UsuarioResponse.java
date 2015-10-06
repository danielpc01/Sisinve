package com.inventario.service.response;

import com.inventario.bean.UsuarioBean;

public class UsuarioResponse extends CommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioBean usuario;

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	
	
}
