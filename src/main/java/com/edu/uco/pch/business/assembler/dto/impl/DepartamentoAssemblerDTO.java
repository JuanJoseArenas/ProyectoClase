package com.edu.uco.pch.business.assembler.dto.impl;

import java.util.List;

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
	public DepartamentoDomain toDomain(final DepartamentoDTO data) {
		var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
		var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(
				departamentoDtoTmp.getId(),
				departamentoDtoTmp.getNombre(),
				paisDomain);
	}

	@Override
	public DepartamentoDTO toDto(DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisDto = paisAssembler.toDto(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build()
				.setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp.getNombre())
				.setPais(paisDto);
	}

	@Override
	public List<DepartamentoDomain> toDomainCollection(List<DepartamentoDTO> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoDTO> toDtoCollection(List<DepartamentoDomain> domainCollection) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
