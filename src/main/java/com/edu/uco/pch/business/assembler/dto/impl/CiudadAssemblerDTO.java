package com.edu.uco.pch.business.assembler.dto.impl;

import com.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import com.edu.uco.pch.business.domain.CiudadDomain;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.dto.CiudadDTO;
import com.edu.uco.pch.dto.DepartamentoDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {
	
	
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = 
			new CiudadAssemblerDTO();
		
	private CiudadAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}
	
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler
	= DepartamentoAssemblerDTO.getInstance();
	
	@Override
	public CiudadDomain toDomain(CiudadDTO data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDTO toDto(CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
