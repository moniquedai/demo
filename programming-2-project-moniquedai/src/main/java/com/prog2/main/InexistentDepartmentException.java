package com.prog2.main;

public class InexistentDepartmentException extends RuntimeException{
	
	public InexistentDepartmentException() {
	}
	
	public InexistentDepartmentException(String message) {
		super(message);
	}

}
