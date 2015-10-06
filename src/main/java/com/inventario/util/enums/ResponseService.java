package com.inventario.util.enums;

public enum ResponseService {

	EXITO(1,"Exito al obtener datos"),
	ERROR(0,"Error al obtener datos");
	
	private int codigo;
	private String mensaje;
	
	
	ResponseService(int cod, String msg){
		codigo=cod;
		mensaje=msg;
	}


	public int getCodigo() {
		return codigo;
	}


	public String getMensaje() {
		return mensaje;
	}
	
	
	
}
