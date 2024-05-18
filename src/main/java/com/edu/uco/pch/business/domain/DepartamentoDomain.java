package com.edu.uco.pch.business.domain;

import java.util.UUID;

import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.Helper.UUIDHelper;

public final class DepartamentoDomain {
	
	private UUID id;
	private String nombre;
	private PaisDomain pais;
	
	
	private DepartamentoDomain(final UUID id, final String nombre, final PaisDomain pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public static final DepartamentoDomain build(final UUID id, final String nombre, final PaisDomain pais) {
		return new DepartamentoDomain(id, nombre, pais);
		
	}
	
	public static final DepartamentoDomain build(final UUID id) {
		return new DepartamentoDomain(id, TextHelper.EMPTY, PaisDomain.build());
		
	}
	
	public static final DepartamentoDomain build() {
		return new DepartamentoDomain(UUIDHelper.getDefault(), TextHelper.EMPTY, PaisDomain.build());
		
	}

	private final UUID getId() {
		return id;
	}


	private final void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}


	private final void setPais(PaisDomain pais) {
		this.pais = pais;
	}


	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public final PaisDomain getPais() {
		return pais;
	}

	public final String getNombre() {
		return nombre;
	}


	
	

}
