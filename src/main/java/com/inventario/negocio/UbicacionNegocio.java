package com.inventario.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.bean.AreaBean;
import com.inventario.bean.DepartamentoBean;
import com.inventario.bean.TiendaBean;

@Service
public interface UbicacionNegocio {

	public List<DepartamentoBean> getDepartamentos();
	public List<TiendaBean> getTiendas(TiendaBean filtroBusq);
	public List<AreaBean> getAreas(AreaBean filtroBusq);
	
	
}
