package com.edu.uco.pch.crosscutting.exception.custom;

import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.enums.Lugar;

public final class DataPCHException extends PCHException {

	private static final long serialVersionUID = 361322697118899300L;
	private static final Lugar lugar = Lugar.DATA;

	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public DataPCHException(final String mensajeUsuario, final String mensajeTecnico) {
		super(mensajeUsuario,mensajeTecnico, lugar);
	}

	public DataPCHException(final String mensajeTecnico, final String mensajeUsuario,
			Throwable exepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, exepcionRaiz);
	}

}