package com.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.entity.DepartamentoEntity;
import com.edu.uco.pch.entity.PaisEntity;

public final class DepartamentoAssemblerEntity implements AssembleEntity<DepartamentoDomain, DepartamentoEntity> {

	
	private static final AssembleEntity<DepartamentoDomain, DepartamentoEntity> instance = 
			new DepartamentoAssemblerEntity();
	private static final AssembleEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
	
	private DepartamentoAssemblerEntity() {
		super();
	}

	public static final AssembleEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}
	
	@Override
	public final DepartamentoDomain toDomain(final DepartamentoEntity data) {
		var departamentoEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, DepartamentoEntity.build());
		var paisDomain = paisAssembler.toDomain(departamentoEntityTmp.getPais());
		return DepartamentoDomain.build(departamentoEntityTmp.getId(), departamentoEntityTmp.getNombre(), paisDomain);
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
		return DepartamentoEntity.build().setId(departamentoDomainTmp.getId())
				.setNombre(departamentoDomainTmp.getNombre()).setPais(paisEntity);
	}

	@Override
	public List<DepartamentoDomain> toDomainCollection(List<DepartamentoEntity> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

}
