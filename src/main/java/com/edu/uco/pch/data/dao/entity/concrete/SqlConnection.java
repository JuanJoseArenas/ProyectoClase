package com.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import com.edu.uco.pch.crosscutting.Helper.SQLHelper;
import com.edu.uco.pch.crosscutting.exception.custom.DataPCHException;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;

public class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}
	
	protected SqlConnection() {
		super();
	}
	
	
	protected final Connection getConexion() {
		return conexion;
	}
	
	protected final void setConexion(final Connection conexion) {
		
		if(!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO con una conexion cerrada";
			
			throw new DataPCHException(mensajeTecnico, mensajeUsuario);
		}
			
		this.conexion = conexion;
	}
	

}
