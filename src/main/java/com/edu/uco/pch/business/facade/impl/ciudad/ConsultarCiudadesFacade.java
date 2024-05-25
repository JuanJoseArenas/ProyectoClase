package com.edu.uco.pch.business.facade.impl.ciudad;

import java.util.List;

import com.edu.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import com.edu.uco.pch.business.facade.FacadeWhitReturn;
import com.edu.uco.pch.business.usecase.impl.ciudad.ConsultarCiudades;
import com.edu.uco.pch.crosscutting.exception.PCHException;
import com.edu.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import com.edu.uco.pch.data.dao.factory.DAOFactory;
import com.edu.uco.pch.dto.CiudadDTO;

public final class ConsultarCiudadesFacade implements FacadeWhitReturn<CiudadDTO, List<CiudadDTO>> {


	private DAOFactory daoFactory;
	
	public ConsultarCiudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public List<CiudadDTO> execute(CiudadDTO dto) {
		try {
		
			var useCase = new ConsultarCiudades(daoFactory);
			var ciudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = useCase.execute(ciudadDomain);
			return CiudadAssemblerDTO.getInstance().toDtoCollection(resultadosDomain);

			
		} catch (PCHException excepcion) {
			throw excepcion;
		} catch (Exception excepcion){
			
			var mensajeUsuaro = "Se ha presentado un problema tratando de consultar la informacion de la ciudad";
			var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de consultar la informacion de la Ciudad";
			
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuaro, excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
