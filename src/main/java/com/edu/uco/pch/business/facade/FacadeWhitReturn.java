package com.edu.uco.pch.business.facade;

public interface FacadeWhitReturn<T , K> {
	
	K execute (T dto);

}
