package com.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.edu.uco.pch.crosscutting.exception.custom.DataPCHException;
import com.edu.uco.pch.data.dao.entity.CiudadDAO;
import com.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import com.edu.uco.pch.entity.CiudadEntity;

public final class CiudadAzureSQLDAO extends SqlConnection implements CiudadDAO {

	public CiudadAzureSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void Create(final CiudadEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO CIUDAD(id, nombre, departamento) ");
		sentenciaSql.append("SELECT ?, ?, ?");
		
		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
			
			
			sentenciaSqlPreparada.executeUpdate();
			
		}catch (final SQLException excepcion) {
			
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la Ciudad \"${1}\", por favor intente de nuevo y si el problema persiste contacte al administrador...";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"${1}\", para mas detalles, revise de forma completa la excepcion raiz presentada;;;";
			
			throw new DataPCHException(mensajeTecnico,mensajeUsuario, excepcion);
			
		}catch (final Exception excepcion) {
			
			var mensajeUsuario = "Se ha presentado un problema tratando de crear la Ciudad \"${1}\", por favor intente de nuevo y si el problema persiste contacte al administrador...";
			var mensajeTecnico = "Se ha presentado una problema INESPERADO con una exception de tipo Exception tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"${1}\", para mas detalles, revise de forma completa la excepcion raiz presentada;;;";
			
			throw new DataPCHException(mensajeTecnico,mensajeUsuario, excepcion);
			
	}
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
