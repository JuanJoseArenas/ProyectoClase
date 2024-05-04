package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class BusinessPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;

	public BusinessPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.BUSINESS);
	}

	public BusinessPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, Lugar.DATA);
	}
	public BusinessPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS, exeptionRaiz);
	}

}