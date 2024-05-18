package com.edu.uco.pch.business.domain;

import java.util.UUID;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.Helper.UUIDHelper;

public class CiudadDomain {

	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	
	private CiudadDomain(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		setId(id);
		setNombre(nombre);
		setDepartamento(departamento);
	
	}
	
	
	public static final CiudadDomain build(final UUID id, final String nombre, final DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
		
	}
	
	public static final CiudadDomain build(final UUID id) {
		return new CiudadDomain(id, TextHelper.EMPTY, DepartamentoDomain.build());
		
	}
	
	public static final CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, DepartamentoDomain.build());
		
	}
	
	
	private final UUID getId() {
		return id;
	}
	
	private final void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());;
	}
	
	private final void setNombre(String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
	}

	private final void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = ObjectHelper.getObjectHelper().getDefaultValue(departamento, DepartamentoDomain.build());
	}
	
	private final String getNombre() {
		return nombre;
	}
	
	private final DepartamentoDomain getDepartamento() {
		return departamento;
	}
}
