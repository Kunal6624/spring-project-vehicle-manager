package com.sipl.vehicle.manager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.sipl.vehicle.manager.dto.UserDto;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.ValidationException;
import com.sipl.vehicle.manager.payload.ApiResponse;
import com.sipl.vehicle.manager.service.VehicleManagerService;
import com.sipl.vehicle.manager.util.validationUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class VehicleManagerControllerImpl implements VehicleManagerController {

	private VehicleManagerService vehicleManagerService;

	@Autowired
	public VehicleManagerControllerImpl(VehicleManagerService vehicleManagerService) {
		super();
		this.vehicleManagerService = vehicleManagerService;
	}

	@Override
	@GetMapping("/vehicle-list/{page_number}/{page_size}")
	public ApiResponse<VehicleDto> listVehicle(@PathVariable("page_number") int pageNumber,
			@PathVariable("page_size") int pageSize) {
		return vehicleManagerService.getAllVehicle(pageNumber, pageSize);

	}

	@Override
	@PostMapping("/add-vehicle")
	public ApiResponse<VehicleDto> createVehicle(@RequestBody VehicleDto theVehicleDto) {
		return vehicleManagerService.addVehicle(theVehicleDto);
	}

	@Override
	@GetMapping("/get-vehicle/{id}")
	public ApiResponse<VehicleDto> getVehicleById(@PathVariable("id") int Id) {
		return vehicleManagerService.getVehicleById(Id);
	}

	@Override
	@PutMapping("/update-vehicle/{id}")
	public ApiResponse<VehicleDto> updateVehicle(@PathVariable("id") int Id, @RequestBody VehicleDto vehicleDto) {
		return vehicleManagerService.updateVehicle(vehicleDto, Id);
	}

	@Override
	@DeleteMapping("/delete-vehicle/{id}")
	public ApiResponse<VehicleDto> deleteVehicle(@PathVariable("id") int Id) {
		return vehicleManagerService.deleteVehicle(Id);
	}

	@Override
	@GetMapping("/get-vehicle-template/{id}")
	public ApiResponse<VehicleDto> getVehicleByRestTemplate(@PathVariable("id") int Id) {
		return vehicleManagerService.getVehicleByRestTemplate(Id);
	}

	@Override
	@GetMapping("/vehicle/export-pdf")
	public void exportDataToPDF() throws DocumentException, IOException {
		vehicleManagerService.exportDataToPDF();
	}

	@Override
	@PostMapping("/user-registration")
	public ApiResponse<UserDto> registerUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			List<ValidationException> ValidationExceptionList = validationUtil
					.getValidationExceptionList(bindingResult);

			return new ApiResponse<UserDto>(null, null, null, ValidationExceptionList, "Invalid fields",
					HttpStatus.NOT_FOUND, true);
		} else {
			try {
				return vehicleManagerService.registerUser(userDto);
			} catch (Exception e) {
				return new ApiResponse<UserDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
						true);
			}
		}
	}

	@Override
	@PostMapping("/user-authentication")
	public ApiResponse<UserDto> authenticateUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<ValidationException> ValidationExceptionList = validationUtil
					.getValidationExceptionList(bindingResult);
			return new ApiResponse<UserDto>(null, null, null, ValidationExceptionList, "Invalid fields",
					HttpStatus.NOT_FOUND, true);
		} else {
			try {
				System.out.println("userDto" + userDto);
				return vehicleManagerService.auntenticateUser(userDto);
			} catch (Exception e) {
				System.out.println("error" + e.getMessage());
				return new ApiResponse<UserDto>(null, null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND,
						true);

			}
		}
	}

}
