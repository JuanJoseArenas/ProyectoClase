package com.edu.uco.pch.business.assembler.entity.impl;


import java.util.ArrayList;
import java.util.List;

import com.edu.uco.pch.business.assembler.entity.AssembleEntity;
import com.edu.uco.pch.business.domain.CiudadDomain;
import com.edu.uco.pch.business.domain.DepartamentoDomain;
import com.edu.uco.pch.crosscutting.Helper.ObjectHelper;
import com.edu.uco.pch.entity.CiudadEntity;
import com.edu.uco.pch.entity.DepartamentoEntity;

public class CiudadAssemblerEntity implements AssembleEntity<CiudadDomain, CiudadEntity> {
	
	private static final AssembleEntity<CiudadDomain, CiudadEntity> instance = 
			new CiudadAssemblerEntity();
	
	private static final AssembleEntity<DepartamentoDomain, DepartamentoEntity> departamentoAssembler 
	= DepartamentoAssemblerEntity.getInstance();
	
	private CiudadAssemblerEntity() {
		super();
	}
	
	public static final AssembleEntity<CiudadDomain, CiudadEntity> getInstance(){
		return instance;
	}
	

	@Override
	public final CiudadDomain toDomain(final CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final CiudadEntity toEntity(final CiudadDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDomain> toDomainCollection(List<CiudadEntity> entityCollection) {
		var entityCollectioTmp = ObjectHelper.getObjectHelper()
				.getDefaultValue(entityCollection, new ArrayList<CiudadEntity>());
		
		return entityCollectioTmp.stream()
				.map(this :: toDomain)
				.toList();
	}

}
