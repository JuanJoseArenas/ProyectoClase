package com.edu.uco.pch.crosscutting.exception.messagecatalog;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.exception.custom.CrosscuttingPCHException;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.Mensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.impl.MessageCatalogBase;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.impl.MessageCatalogExternalService;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();
	
	
	static {
		inicializar();
	}
	
	private MessageCatalogStrategy() {
		super();
		
	}
	
	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();		

	}
	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}
	
	public static final Mensaje getMensaje(final CodigoMensaje codigo, 
			final String...parametros) {
		
		if(ObjectHelper.getObjectHelper().isNull(codigo)){
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico =  MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
	}
	
	public static final String getContenidoMensaje(final CodigoMensaje codigo, 
			final String...parametros) {
		return TextHelper.reemplazarParametro(getMensaje(codigo, parametros).getContenido(), parametros) ;
	}

}
