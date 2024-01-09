package com.sipl.vehicle.manager.exception.handler;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sipl.vehicle.manager.payload.ApiErrorResponse;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	public ApiErrorResponse NoSuchElementException(NoSuchElementException noSuchElementException) {
		return new ApiErrorResponse("Vehicle Not Found", false, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ApiErrorResponse duplicateValueException(
			DataIntegrityViolationException dataIntegrityViolationException) {
		return new ApiErrorResponse("Vehicle with Vehicle_Registration_Number already exist", false, HttpStatus.NOT_FOUND);
	}

}
