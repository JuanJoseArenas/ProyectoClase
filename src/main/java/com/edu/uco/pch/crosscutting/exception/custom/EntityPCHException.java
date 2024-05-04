package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class EntityPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;

	public EntityPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.ENTITY);
	}

	public EntityPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, Lugar.DATA);
	}
	
	public EntityPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.ENTITY, exeptionRaiz);
	}

}