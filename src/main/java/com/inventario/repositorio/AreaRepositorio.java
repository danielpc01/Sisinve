package com.inventario.repositorio;

import java.util.List;

import com.inventario.persistencia.Area;


public interface AreaRepositorio {

	/*public List<AreaBean> getAreas(AreaBean filtroBusq);
	public AreaBean getArea(String idArea);*/
	
	public List<Area> getAreas(int idTienda);
	public Area getArea(int idArea);
	
}

