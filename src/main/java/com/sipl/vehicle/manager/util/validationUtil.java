package com.sipl.vehicle.manager.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.sipl.vehicle.manager.exception.ValidationException;

public class validationUtil {

	public static List<ValidationException> getValidationExceptionList(BindingResult bindingResult) {

		List<ValidationException> ValidationExceptionList = new ArrayList<>();
		bindingResult.getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			ValidationException errorObj = new ValidationException(fieldName, message);
			ValidationExceptionList.add(errorObj);
		});
		
		return ValidationExceptionList;

	}

}
