package com.edu.uco.pch.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.edu.uco.pch.crosscutting.Helper.SQLHelper;
import com.edu.uco.pch.data.dao.entity.CiudadDAO;
import com.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.CiudadAzureSQLDAO;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.DepartamentoAzureSQLDAO;
import com.edu.uco.pch.data.dao.entity.concrete.azuresql.PaisAzureSQLDAO;
import com.edu.uco.pch.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFActory extends SqlConnection implements DAOFactory{
	
	

	public AzureSQLDAOFActory() {
		super();
		abrirConexion();
	}

	@Override
	public void abrirConexion() {
		try {
			String connecString = "hsdhyrtssadtyrhg";
			setConexion(DriverManager.getConnection(connecString));
		} catch (final SQLException excepcion) {
			
		} catch (final Exception exception) {
			
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

}
