package com.sipl.vehicle.manager.exception.handler;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sipl.vehicle.manager.exception.ResourceNotFoundException;
import com.sipl.vehicle.manager.payload.ApiErrorResponse;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		System.out.println(resourceNotFoundException.getMessage());
		  ApiErrorResponse  er = new ApiErrorResponse(resourceNotFoundException.getMessage(), false, HttpStatus.NOT_FOUND);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiErrorResponse> handleNoSuchElementException(NoSuchElementException elementException) {
		System.out.println(elementException.getMessage());
		  ApiErrorResponse  er = new ApiErrorResponse("Entry Not Found", false, HttpStatus.NOT_FOUND);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ApiErrorResponse> handleDuplicateEntryException(DataIntegrityViolationException duplicateException) {
		System.out.println(duplicateException.getMessage());
		  ApiErrorResponse  er = new ApiErrorResponse("Vehicle with Vehicle_Registration_number already exist", false, HttpStatus.NOT_FOUND);
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
	

}
