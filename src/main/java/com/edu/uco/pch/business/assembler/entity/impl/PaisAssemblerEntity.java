package com.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.entity.PaisEntity;

public final class PaisAssemblerEntity implements AssembleEntity<PaisDomain, PaisEntity> {
	
	private static final AssembleEntity<PaisDomain, PaisEntity> instance = 
			new PaisAssemblerEntity();
	
	
	private PaisAssemblerEntity() {
		super();
	}
	
	public static final AssembleEntity<PaisDomain, PaisEntity> getInstance(){
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final PaisEntity toEntity(final PaisDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDomain> toDomainCollection(List<PaisEntity> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

}
