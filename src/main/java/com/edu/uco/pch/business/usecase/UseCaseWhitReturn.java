package com.edu.uco.pch.business.usecase;

public interface UseCaseWhitReturn<T,R> {
	
	R execute (T data);

}
