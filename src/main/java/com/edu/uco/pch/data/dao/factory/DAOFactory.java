package com.edu.uco.pch.data.dao.factory;

import com.edu.uco.pch.data.dao.entity.CiudadDAO;
import com.edu.uco.pch.data.dao.entity.DepartamentoDAO;
import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.data.dao.factory.concrete.AzureSQLDAOFActory;

public interface DAOFactory {

	static DAOFactory getFactory() {
		return new AzureSQLDAOFActory();
	}

	void cerrarConexion();

	void iniciarTransaccion();

	void confirmarTransaccion();

	void cancelarTransaccion();

	PaisDAO getPaisDAO();

	DepartamentoDAO getDepartamentoDAO();

	CiudadDAO getCiudadDAO();
}
