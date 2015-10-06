package com.inventario.repositorio.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.persistencia.Tienda;
import com.inventario.repositorio.TiendaRepositorio;

@Repository
public class TiendaRepositorioImpl implements TiendaRepositorio{
	
	
	@Autowired
	private SessionFactory sessionfactory;
	

	@SuppressWarnings("unchecked")
	public List<Tienda> getTiendasPorDepa(int idDepartamento) {
		
		String query="from Tienda t where t.departamento.id = :idDepa ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		objQuery.setInteger("idDepa", idDepartamento);
		List<Tienda> listaTienda=objQuery.list();
		
		
		session.close();
		return listaTienda;
	}	
}
