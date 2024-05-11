package com.edu.uco.pch.data.dao.entity;

import java.util.UUID;

import com.edu.uco.pch.entity.CiudadEntity;


public interface CiudadDAO 
		extends CreateDAO<CiudadEntity>, RetriveDAO<CiudadEntity>, UpdateDAO<CiudadEntity>, DeleateDAO<UUID>{

} 

