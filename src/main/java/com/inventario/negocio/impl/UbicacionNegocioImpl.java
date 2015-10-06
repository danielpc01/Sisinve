package com.inventario.negocio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventario.bean.AreaBean;
import com.inventario.bean.DepartamentoBean;
import com.inventario.bean.TiendaBean;
import com.inventario.negocio.UbicacionNegocio;
import com.inventario.persistencia.Area;
import com.inventario.persistencia.Departamento;
import com.inventario.persistencia.Tienda;
import com.inventario.repositorio.AreaRepositorio;
import com.inventario.repositorio.DepartamentoRepositorio;
import com.inventario.repositorio.TiendaRepositorio;

@Service
@Transactional
public class UbicacionNegocioImpl implements UbicacionNegocio {

	
	
	@Autowired
	private DepartamentoRepositorio depaRepositorio;
	
	@Autowired
	private TiendaRepositorio tiendaRepositorio;
	
	@Autowired
	private AreaRepositorio areaRepositorio;
	
	public List<DepartamentoBean> getDepartamentos() {
		List<DepartamentoBean> lista = new ArrayList<DepartamentoBean>();
		List<Departamento> listaDepa=depaRepositorio.getDepartamentos();
		for(Departamento depa :listaDepa){
			DepartamentoBean depaBean=new DepartamentoBean();
			depaBean.setId(String.valueOf(depa.getId()));
			depaBean.setNombre(depa.getNombre());
			lista.add(depaBean);
		}
		return lista;
	}

	public List<TiendaBean> getTiendas(TiendaBean filtroBusq) {
		List<TiendaBean> lista=new ArrayList<TiendaBean>();
		try{
			if(filtroBusq!=null){
				if(filtroBusq.getIdDepa()!=null && !filtroBusq.getIdDepa().trim().isEmpty()){
					List<Tienda> listaTienda= tiendaRepositorio.getTiendasPorDepa(
							Integer.parseInt(filtroBusq.getIdDepa()));
					for(Tienda tienda :listaTienda){
						TiendaBean tiendaBean=new TiendaBean();
						tiendaBean.setId(String.valueOf(tienda.getId()));
						tiendaBean.setNombre(tienda.getNombre());
						
						tiendaBean.setIdDepa(String.valueOf(tienda.getDepartamento().getId()));
						tiendaBean.setNombreDepa(tienda.getDepartamento().getNombre());
						lista.add(tiendaBean);
					}
				}
			}
		}catch(Exception e){
			
		}
		
		
		
		
		
		return lista;
	}

	public List<AreaBean> getAreas(AreaBean filtroBusq) {
		List<AreaBean> lista=new ArrayList<AreaBean>();
		try{
			if(filtroBusq!=null){
				if(filtroBusq.getIdTienda()!=null && !filtroBusq.getIdTienda().trim().isEmpty()){
					List<Area> listaArea=areaRepositorio.getAreas(
							Integer.parseInt(filtroBusq.getIdTienda()));
					for(Area tienda :listaArea){
						AreaBean areaBean=new AreaBean();
						areaBean.setId(String.valueOf(tienda.getId()));
						areaBean.setNombre(tienda.getNombre());
						
						areaBean.setIdTienda(String.valueOf(tienda.getTienda().getId()));
						areaBean.setNombreTienda(tienda.getTienda().getNombre());
						lista.add(areaBean);
					}
				}
			}
		}catch(Exception e){
			
		}
		return lista;
	}

}
