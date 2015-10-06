package com.inventario.repositorio;

import java.util.List;

import com.inventario.persistencia.Tienda;


public interface TiendaRepositorio {

	public List<Tienda> getTiendasPorDepa(int idDepartamento);
	
}

