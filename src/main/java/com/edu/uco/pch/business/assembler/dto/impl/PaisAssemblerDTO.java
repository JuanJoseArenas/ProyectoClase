package com.edu.uco.pch.business.assembler.dto.impl;

import java.util.List;

import com.edu.uco.pch.business.assembler.dto.AssemblerDTO;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.dto.PaisDTO;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO> {
	
	
	private static final AssemblerDTO<PaisDomain, PaisDTO> instance 
	= new PaisAssemblerDTO();
	
	
	private PaisAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance(){
		return instance;
	}
	

	@Override
	public final PaisDomain toDomain(final PaisDTO data) {
		var paisDtoTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, PaisDTO.build());
		return PaisDomain.build(paisDtoTmp.getId(), paisDtoTmp.getNombre());
	}

	@Override
	public final PaisDTO toDto(final PaisDomain domain) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

	@Override
	public List<PaisDomain> toDomainCollection(List<PaisDTO> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> toDtoCollection(List<PaisDomain> domainCollection) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
