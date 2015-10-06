package com.inventario.bean;

import java.io.Serializable;

public class TiendaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private String idDepa;
	private String nombreDepa;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(String idDepa) {
		this.idDepa = idDepa;
	}
	public String getNombreDepa() {
		return nombreDepa;
	}
	public void setNombreDepa(String nombreDepa) {
		this.nombreDepa = nombreDepa;
	}
	
}
