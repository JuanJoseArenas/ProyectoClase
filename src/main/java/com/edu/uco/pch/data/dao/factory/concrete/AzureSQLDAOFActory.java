package com.edu.uco.pch.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.edu.uco.pch.crosscutting.Helper.SQLHelper;
import com.edu.uco.pch.crosscutting.Helper.UUIDHelper;
import com.edu.uco.pch.crosscutting.exception.custom.DataPCHException;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import com.edu.uco.pch.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import com.edu.uco.pch.data.dao.entity.CiudadDAO;
import com.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.CiudadAzureSQLDAO;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.DepartamentoAzureSQLDAO;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.PaisAzureSQLDAO;
import com.edu.uco.pch.data.dao.factory.DAOFactory;
import com.edu.uco.pch.entity.CiudadEntity;
import com.edu.uco.pch.entity.DepartamentoEntity;

public final class AzureSQLDAOFActory extends SqlConnection implements DAOFactory {

	public AzureSQLDAOFActory() {
		super();
		abrirConexion();
	}

	private void abrirConexion() {
		final String connectionUrl = "jdbc:sqlserver://wednesday.database.windows.net:1433;databaseName=friday;user=fridayDmlUser;password=fr1d4yus3r!";
		try {
			setConexion(DriverManager.getConnection(connectionUrl));
		} catch (final SQLException excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		} catch (final Exception excepcion) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}
	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());
	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PaisAzureSQLDAO(getConexion());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoAzureSQLDAO(getConexion());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadAzureSQLDAO(getConexion());
	}

//	public static void main(String[] args) {
//		try {
//			DAOFactory factory = DAOFactory.getFactory();
//
//			System.out.println("Iniciando transacción...");
//			factory.iniciarTransaccion();
//
//			System.out.println("Creando ciudad aleatoriamente");
//			DepartamentoEntity departamento = DepartamentoEntity.build()
//					.setId(UUIDHelper.convertToUUID("7827155D-0A6B-4D6E-9807-C5B7097D94F0"));
//			CiudadEntity ciudad = CiudadEntity.build().setId(UUIDHelper.generate())
//					.setNombre("Rionegro-" + UUIDHelper.generate()).setDepartamento(departamento);
//
//			factory.getCiudadDAO().Create(ciudad);
//
//			System.out.println("Consultamos ciudades: ");
//			var resultados = factory.getCiudadDAO().consultar(CiudadEntity.build());
//
//			for (CiudadEntity ciudadEntity : resultados) {
//				System.out.println("idCiudad: " + ciudadEntity.getId() + ", nombreCiudad: " + ciudadEntity.getNombre()
//						+ ", idDepartamento: " + ciudadEntity.getDepartamento().getId() + ", nombreDepartamento: "
//						+ ciudadEntity.getDepartamento().getNombre() + ", idPais: "
//						+ ciudadEntity.getDepartamento().getPais().getId() + ", nombrePais: "
//						+ ciudadEntity.getDepartamento().getPais().getNombre());
//			}
//
//			System.out.println("Confirmando transacción...");
//			factory.confirmarTransaccion();
//			System.out.println("Cerrando conexión...");
//			factory.cerrarConexion();
//		} catch (final Exception excepcion) {
//			excepcion.printStackTrace();
//		}
//	}
}

