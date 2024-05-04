package com.edu.uco.pch.crosscutting.exception.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.exception.custom.CrosscuttingPCHException;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.MessageCatalog;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.Mensaje;

public final class MessageCatalogBase implements MessageCatalog{
	
	private final Map<String, Mensaje> mensajes = new HashMap<> ();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M000001.getIdentificador(),
				new Mensaje(CodigoMensaje.M000001, "El codigo del mensaje que se quiere obtener del catalogo de mensajes llego nulo"));
		mensajes.put(CodigoMensaje.M000002.getIdentificador(), 
				new Mensaje(CodigoMensaje.M000002, "Se ha presentado un problema tratando de llevar a cabo la operacion deseada"));
		mensajes.put(CodigoMensaje.M000003.getIdentificador(), 
				new Mensaje(CodigoMensaje.M000003, "El identificador del mensaje \"${1}\" que que se intento obtener, no esta en el catalogo de mensajes base"));
		mensajes.put(CodigoMensaje.M000004.getIdentificador(), 
				new Mensaje(CodigoMensaje.M000004, "El mensaje con identificador \"${1}\" que que se intento obtener, no esta configurado para recibir en el catalogo de mensajes base"));
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo,final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String... parametros) {
		
		if(ObjectHelper.getObjectHelper().isNull(codigo)){
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M000002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M000001);
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		if(codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M000002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M000004,codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M000002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M000003,codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		return mensajes.get(codigo.getIdentificador());
	}

}
