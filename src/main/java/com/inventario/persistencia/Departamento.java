package com.inventario.persistencia;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Tienda
	@OneToMany(mappedBy="departamento")
	private List<Tienda> tiendas;

	public Departamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tienda> getTiendas() {
		return this.tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Tienda addTienda(Tienda tienda) {
		getTiendas().add(tienda);
		tienda.setDepartamento(this);

		return tienda;
	}

	public Tienda removeTienda(Tienda tienda) {
		getTiendas().remove(tienda);
		tienda.setDepartamento(null);

		return tienda;
	}

}