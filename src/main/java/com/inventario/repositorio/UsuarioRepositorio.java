package com.inventario.repositorio;

import com.inventario.persistencia.Usuario;

public interface UsuarioRepositorio {

	public Usuario getUsuario(String codigo, String password);
	public Usuario getUsuarioPorId(int idUsu);
}
