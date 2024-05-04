package com.edu.uco.pch.crosscutting.exception.messagecatalog;

import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.Mensaje;

public interface MessageCatalog {
	
	void inicializar();
	
	String obtenerContenidoMensaje(final CodigoMensaje codigo, String...parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo, String...parametros);

}
