package com.edu.uco.pch.crosscutting.exception.messagecatalog;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.exception.custom.CrosscuttingPCHException;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.Mensaje;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.impl.MessageCatalogBase;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.impl.MessageCatalogExternalService;

public final class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();
	
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
	
	public static final Mensaje getMensaje9(final CodigoMensaje codigo, 
			final String...parametros) {
		
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			throw new CrosscuttingPCHException(null, null,null);
		}
		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);
	}

}
