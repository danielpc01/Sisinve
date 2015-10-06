package com.inventario.repositorio.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventario.persistencia.Usuario;
import com.inventario.repositorio.UsuarioRepositorio;

@Repository
public class UsuarioRepositorioImpl implements UsuarioRepositorio{
	
	
	@Autowired
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	public Usuario getUsuario(String codigo, String password) {
		String query="from Usuario t where t.codigo = :cod and t.password= :pass ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		objQuery.setString("cod", codigo);
		objQuery.setString("pass", password);
		List<Usuario> listaUsu=objQuery.list();
	
		session.close();
		
		
		
		return listaUsu.size()>0?listaUsu.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario getUsuarioPorId(int idUsuario) {
		String query="from Usuario t where t.id= :idUsu ";
		Session session=sessionfactory.openSession();
		Query objQuery=session.createQuery(query);
		objQuery.setInteger("idUsu", idUsuario);
		
		List<Usuario> listaUsu=objQuery.list();
	
		session.close();
		return listaUsu.size()>0?listaUsu.get(0):null;
	}

		
}
