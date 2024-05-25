package com.edu.uco.pch.business.facade.impl.ciudad;

import com.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import com.edu.uco.pch.business.facade.FacadeWhitoutReturn;
import com.edu.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import com.edu.uco.pch.data.dao.factory.DAOFactory;
import com.edu.uco.pch.dto.CiudadDTO;

public final class RegistrarCiudadFacade implements FacadeWhitoutReturn<CiudadDTO>{
	
	private DAOFactory daoFactory;
	
	public RegistrarCiudadFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(CiudadDTO dto) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			
			var useCase = new RegistrarCiudad(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			
			useCase.execute(ciudadDomain);
			
			
			daoFactory.confirmarTransaccion();
			
		} catch (PCHException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion){
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuaro = "Se ha presentado un problema tratando de registrar la informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la informacion de la Ciudad";
			
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuaro, excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
