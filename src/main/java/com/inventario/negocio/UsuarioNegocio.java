package com.inventario.negocio;

import org.springframework.stereotype.Service;

import com.inventario.bean.UsuarioBean;

@Service
public interface UsuarioNegocio {

	public UsuarioBean getUsuario(String codigo, String pass);
}
