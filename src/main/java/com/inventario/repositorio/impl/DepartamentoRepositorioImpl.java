package com.inventario.repositorio.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.persistencia.Departamento;
import com.inventario.repositorio.DepartamentoRepositorio;

@Repository
public class DepartamentoRepositorioImpl implements DepartamentoRepositorio{
	
	
	@Autowired
	private SessionFactory sessionfactory;
	
	@SuppressWarnings("unchecked")
	public List<Departamento> getDepartamentos() {
		String query="from Departamento ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		List<Departamento> listaDepa=objQuery.list();
		
		session.close();
		return listaDepa;
	}	
}
