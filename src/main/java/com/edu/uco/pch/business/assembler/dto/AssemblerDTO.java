package com.edu.uco.pch.business.assembler.dto;

import java.util.List;

import com.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerDTO<D, K> extends Assembler<D, K>{
	
	K toDto(D domain);
	
	List<K> toDtoCollection(List<D> domainCollection);

}
