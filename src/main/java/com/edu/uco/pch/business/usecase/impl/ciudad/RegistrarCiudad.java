package com.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;

import com.edu.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import com.edu.uco.pch.business.domain.CiudadDomain;
import com.edu.uco.pch.business.usecase.UseCaseWhitoutReturn;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.crosscutting.Helper.UUIDHelper;
import com.edu.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import com.edu.uco.pch.data.dao.factory.DAOFactory;
import com.edu.uco.pch.entity.CiudadEntity;

public final class RegistrarCiudad implements UseCaseWhitoutReturn<CiudadDomain> {
	
	private DAOFactory factory;
	
	
	public RegistrarCiudad(final DAOFactory factory) {
		if(ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = "Se ha presentado un problema tratando de llevar un registro de la ciudad...";
			var mensajeTecnico = "El dao factory para crear la ciudad llego nulo...";
			throw new BusinessPCHException(mensajeUsuario, mensajeTecnico);
		}
		
		this.factory = factory;
	}
	

	@Override
	public void execute(final CiudadDomain data) {
		// 1. validar que los datos requeridos par el caso de uso sean correctos a nivel de tipo de dato, rango, formato
		// 2. Validar que no exista una misma ciudad para un mismo departamento
		
		
//		var ciudadEntoty = CiudadEntity.build().setId(generarIdentificadorCiudad()).setNombre(null)
//		
//		// 3. validar que no exista otra ciudad con el mismo identificador
//		private final UUID generarIdentificadorCiudad() {
//			UUID id = UUIDHelper.generarUUIDDefecto();
//			boolean existeId = true;
//			
//			while (existeId) {
//				id = UUIDHelper.generarUUIDDefecto();
//				var ciudadEntity = CiudadEntity.build().setId(id);
//				var resultados = factory.getCiudadDAO().consultar(CiudadEntity);
//				existeId = !resultados.isEmpty();
//			}
//			return id;
//		}
		
		
		
		// 4. Guardar la nueva tarea
		var ciudadEntity = CiudadAssemblerEntity.getInstance().toEntity(data);
		factory.getCiudadDAO().Create(ciudadEntity);
		
	}

}
