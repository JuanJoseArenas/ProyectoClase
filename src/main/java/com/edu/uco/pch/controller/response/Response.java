package com.edu.uco.pch.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private List<String> mensajes = new ArrayList<String>();
	private List<T> datos;
	
	
	public final List<String> getMensajes() {
		return mensajes;
	}
	
	public final List<T> getDatos() {
		return datos;
	}
	
	public final void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	public final void setDatos(List<T> datos) {
		this.datos = datos;
	}
	
	
 
}
