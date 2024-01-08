package com.sipl.vehicle.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class DuplicateValueException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	
	public DuplicateValueException(String resourceName, String fieldName) {
		super(String.format("%s with %s already exist", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}
	
	
	public String getResourceName() {
		return resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}

}
