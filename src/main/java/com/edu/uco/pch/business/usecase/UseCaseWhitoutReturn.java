package com.edu.uco.pch.business.usecase;

public interface UseCaseWhitoutReturn<T> {
	
	void execute (T data);

}
