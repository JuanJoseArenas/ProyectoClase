package com.edu.uco.pch.data.dao.entity;

import java.util.List;

interface RetriveDAO<E>{
	
	List<E> consultar(E data);

}
