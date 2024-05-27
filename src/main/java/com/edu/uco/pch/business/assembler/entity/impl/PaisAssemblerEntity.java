package com.edu.uco.pch.business.assembler.entity.impl;

import java.util.List;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.PaisDomain;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
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
		var paisEntityTmp = ObjectHelper.getObjectHelper().getDefaultValue(data, PaisEntity.build());
		return PaisDomain.build(paisEntityTmp.getId(), paisEntityTmp.getNombre());
	}

	@Override
	public final PaisEntity toEntity(final PaisDomain domain) {
		var paisDomainTmp = ObjectHelper.getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisEntity.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

	@Override
	public List<PaisDomain> toDomainCollection(List<PaisEntity> entityCollection) {
		// TODO Auto-generated method stub
		return null;
	}

}
