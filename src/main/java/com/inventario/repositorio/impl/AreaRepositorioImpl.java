package com.inventario.repositorio.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.persistencia.Area;
import com.inventario.repositorio.AreaRepositorio;

@Repository
public class AreaRepositorioImpl implements AreaRepositorio{
	
	
	@Autowired
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	public List<Area> getAreas(int idTienda) {
		
		String query="from Area t where t.tienda.id = :idTienda ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		objQuery.setInteger("idTienda", idTienda);
		List<Area> listaArea=objQuery.list();
		session.close();
		return listaArea;
	}
	
	@SuppressWarnings("unchecked")
	public Area getArea(int idArea) {
		String query="from Area t where t.id = :idArea ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		objQuery.setInteger("idArea", idArea);
		List<Area> listaArea=objQuery.list();
		session.close();
		return listaArea.get(0);
	}	
}
