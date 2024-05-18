package com.edu.uco.pch.business.assembler.dto.impl;

import com.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.dto.DepartamentoDTO;
import com.edu.uco.pch.dto.PaisDTO;

public final class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO> {

	private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler
		= PaisAssemblerDTO.getInstance();
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> instance 
	= new DepartamentoAssemblerDTO();
	
	private DepartamentoAssemblerDTO() {
		super();
	}

	public static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance(){
		return instance;
	}
	
	@Override
	public DepartamentoDomain toDomain(DepartamentoDTO data) {
		var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
		var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(),paisDomain);
	}

	@Override
	public DepartamentoDTO toDto(DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		
		return null;
	}
	

}
