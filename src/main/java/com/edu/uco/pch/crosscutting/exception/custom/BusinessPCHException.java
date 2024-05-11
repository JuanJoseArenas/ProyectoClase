package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class BusinessPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;
	private static final Lugar lugar = Lugar.BUSINESS;

	public BusinessPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public BusinessPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, lugar);
	}
	public BusinessPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, exepcionRaiz);
	}

}