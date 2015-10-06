package com.inventario.negocio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.bean.UsuarioBean;
import com.inventario.negocio.UsuarioNegocio;
import com.inventario.persistencia.Usuario;
import com.inventario.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public UsuarioBean getUsuario(String codigo, String pass) {
		UsuarioBean usuarioBean=null;
		Usuario usuario = usuarioRepositorio.getUsuario(codigo, pass);
		if(usuario!=null){
			usuarioBean =new UsuarioBean();
			usuarioBean.setCodUsuario(usuario.getCodigo());
			usuarioBean.setNomUsuario(usuario.getNombre());
			usuarioBean.setIdUsuario(String.valueOf(usuario.getId()));
		}
		
		return usuarioBean;
	}

}
