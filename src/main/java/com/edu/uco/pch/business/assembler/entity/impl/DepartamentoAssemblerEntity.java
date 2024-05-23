package com.edu.uco.pch.business.assembler.entity.impl;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.business.domain.PaisDomain;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
