package com.edu.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.util.List;

import com.edu.uco.pch.data.dao.entity.PaisDAO;
import com.edu.uco.pch.data.dao.entity.concrete.SqlConnection;
import com.edu.uco.pch.entity.PaisEntity;

public class PaisAzureSQLDAO extends SqlConnection implements PaisDAO {
	
	
	public PaisAzureSQLDAO(final Connection conexion) {
		super(conexion);
	}
	

	@Override
	public List<PaisEntity> consultar(PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
