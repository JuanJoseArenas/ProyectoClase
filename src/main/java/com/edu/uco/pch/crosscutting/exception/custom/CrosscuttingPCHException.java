package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class CrosscuttingPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;

	public CrosscuttingPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CROSSCUTTING);
	}
	
	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING);
	}

	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CROSSCUTTING, exeptionRaiz);
	}

}