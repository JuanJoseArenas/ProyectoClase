package com.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.TextHelper;
import com.edu.uco.pch.crosscutting.exception.custom.DataPCHException;
import com.edu.uco.pch.data.dao.entity.CiudadDAO;
import com.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import com.edu.uco.pch.entity.CiudadEntity;
import com.edu.uco.pch.entity.DepartamentoEntity;

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

		} catch (final SQLException excepcion) {

			var mensajeUsuario = "Se ha presentado un problema tratando de crear la Ciudad \"${1}\", por favor intente de nuevo y si el problema persiste contacte al administrador...";
			var mensajeTecnico = "Se ha presentado una excepcion de tipo SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"${1}\", para mas detalles, revise de forma completa la excepcion raiz presentada;;;";

			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);

		} catch (final Exception excepcion) {

			var mensajeUsuario = "Se ha presentado un problema tratando de crear la Ciudad \"${1}\", por favor intente de nuevo y si el problema persiste contacte al administrador...";
			var mensajeTecnico = "Se ha presentado una problema INESPERADO con una exception de tipo Exception tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"${1}\", para mas detalles, revise de forma completa la excepcion raiz presentada;;;";

			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);

		}
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		sentenciaSql.append("SELECT id, nombre, departamento FROM Ciudad WHERE 1=1");

		final List<Object> parametros = new ArrayList<>();

		if (!ObjectHelper.getObjectHelper().isNull(data.getId())) {
			sentenciaSql.append(" AND id = ?");
			parametros.add(data.getId());
		}
		if (!TextHelper.isNullOrEmpty(data.getNombre())) {
			sentenciaSql.append(" AND nombre = ?");
			parametros.add(data.getNombre());
		}
		if (!ObjectHelper.getObjectHelper().isNull(data.getDepartamento())
				&& !ObjectHelper.getObjectHelper().isNull(data.getDepartamento().getId())) {
			sentenciaSql.append(" AND departamento = ?");
			parametros.add(data.getDepartamento().getId());
		}

		final List<CiudadEntity> ciudades = new ArrayList<>();

		try (final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {

			for (int i = 0; i < parametros.size(); i++) {
				sentenciaSqlPreparada.setObject(i + 1, parametros.get(i));
			}

			try (final ResultSet resultado = sentenciaSqlPreparada.executeQuery()) {
				while (resultado.next()) {
					CiudadEntity ciudad = new CiudadEntity();
					ciudad.setId((UUID) resultado.getObject("id"));
					ciudad.setNombre(resultado.getString("nombre"));
					DepartamentoEntity departamento = new DepartamentoEntity();
					departamento.setId((UUID) resultado.getObject("departamento"));
					ciudad.setDepartamento(departamento);
					ciudades.add(ciudad);
				}
			}

		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar la consulta de las ciudades en la tabla \"Ciudad\" de la base de datos Azure SQL.";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema tratando de consultar las ciudades. Por favor, contacte al administrador del sistema.";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una excepción de tipo Exception tratando de realizar la consulta de las ciudades en la tabla \"Ciudad\" de la base de datos Azure SQL.";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
		}

		return ciudades;
	}

	@Override
	public void modificar(CiudadEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();

		sentenciaSql.append("UPDATE Ciudad SET nombre = ?, departamento = ? WHERE id = ?");

		try (final PreparedStatement sentenciaSqlPreparada = getConexion()
				.prepareStatement(sentenciaSql.toString())) {

			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());

			sentenciaSqlPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {

			var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una exception de tipo exeption tratando de realizar el insert de la ciudad \"${1}\" en la tabla \\\"Pais\\\" de la base de datos Azure SQL";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
		}

	}

	@Override
	public void eliminar(UUID id) {
		final StringBuilder sentenciaSql = new StringBuilder();

		sentenciaSql.append("DELETE FROM Ciudad WHERE id = ?");

		try (final PreparedStatement sentenciaSqlPreparada = getConexion()
				.prepareStatement(sentenciaSql.toString())) {

			sentenciaSqlPreparada.setObject(1, id);

			sentenciaSqlPreparada.executeUpdate();

		} catch (final SQLException excepcion) {
			var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
			var mensajeTecnico = "Se ha presentado una SQLException tratando de realizar el insert de la ciudad \"${1}\" en la tabla \"Pais\" de la base de datos Azure SQL";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);

		} catch (final Exception excepcion) {

			var mensajeUsuario = "Se ha presaentado un problema tratando de crear la ciudad \"${1}\" por favor contatcte al administrador del sistema";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO con una exception de tipo exeption tratando de realizar el insert de la ciudad \"${1}\" en la tabla \\\"Pais\\\" de la base de datos Azure SQL";

			throw new DataPCHException(mensajeUsuario, mensajeTecnico, excepcion);
		}

	}

}