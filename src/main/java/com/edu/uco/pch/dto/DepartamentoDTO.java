package com.edu.uco.pch.dto;

import java.util.UUID;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.Helper.UUIDHelper;

public final class DepartamentoDTO {
	private UUID id;
	private String nombre;
	private PaisDTO pais;

	public DepartamentoDTO() {
		super();
		setId(UUIDHelper.getDefault());
		setNombre(TextHelper.EMPTY);
		setPais(PaisDTO.build());

	}

	public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
		setId(id);
		setNombre(nombre);
		setPais(pais);
	}

	public static final DepartamentoDTO build() {
		return new DepartamentoDTO();
	}

	public final UUID getId() {
		return id;
	}

	public final DepartamentoDTO setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id,	UUIDHelper.getDefault());
		return this;
	}

	public final String getNombre() {
		return nombre;
	}

	public final DepartamentoDTO setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}

	public final PaisDTO getPais() {
		return pais;
	}

	public final DepartamentoDTO setPais(final PaisDTO pais) {
		this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisDTO());
		return this;
	}

}
