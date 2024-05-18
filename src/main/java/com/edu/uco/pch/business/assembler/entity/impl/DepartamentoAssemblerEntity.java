package com.edu.uco.pch.business.assembler.entity.impl;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.entity.DepartamentoEntity;

public class DepartamentoAssemblerEntity implements AssembleEntity<DepartamentoDomain, DepartamentoEntity> {

	
	private static final AssembleEntity<DepartamentoDomain, DepartamentoEntity> instance = 
			new DepartamentoAssemblerEntity();
	
	private DepartamentoAssemblerEntity() {
		super();
	}

	public static final AssembleEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}
	
	@Override
	public DepartamentoDomain toDomain(DepartamentoEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

}
