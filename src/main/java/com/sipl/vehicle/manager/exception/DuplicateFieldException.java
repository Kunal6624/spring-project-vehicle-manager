package com.sipl.vehicle.manager.exception;

public class DuplicateFieldException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	
	public DuplicateFieldException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%s with %s : '%s' already exist", resourceName, fieldName, fieldValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}


	public String getFieldName() {
		return fieldName;
	}


	public Object getFieldValue() {
		return fieldValue;
	}

}
