package com.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import com.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import com.edu.uco.pch.business.domain.CiudadDomain;
import com.edu.uco.pch.business.usecase.UseCaseWhitReturn;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import com.edu.uco.pch.data.dao.factory.DAOFactory;

public class ConsultarCiudades implements UseCaseWhitReturn<CiudadDomain, List<CiudadDomain>> {

	
	private DAOFactory factory;
	
	
	public ConsultarCiudades(final DAOFactory factory) {
		if(ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar a cabo la consulta de las ciudades...";
			var mensajeTecnico = "El dao factory para consultar la ciudad llego nulo...";
			throw new BusinessPCHException(mensajeUsuario, mensajeTecnico);
		}
		
		this.factory = factory;
	}
	
	@Override
	public List<CiudadDomain> execute(final CiudadDomain data) {
		var ciudadEntityFilter = 
				CiudadAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getCiudadDAO().consultar(ciudadEntityFilter);
		
		
		return CiudadAssemblerEntity.getInstance().
				toDomainCollection(resultadosEntity);
	}

}
