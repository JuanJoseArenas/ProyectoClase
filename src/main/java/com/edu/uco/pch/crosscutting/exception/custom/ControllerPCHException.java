package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class ControllerPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;

	public ControllerPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, Lugar.CONTROLLER);
	}
	
	public ControllerPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, Lugar.DATA);
	}

	public ControllerPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exeptionRaiz) {
		super(mensajeTecnico, mensajeUsuario, Lugar.CONTROLLER, exeptionRaiz);
	}

}