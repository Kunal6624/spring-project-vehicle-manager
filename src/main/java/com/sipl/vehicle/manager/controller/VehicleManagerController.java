package com.sipl.vehicle.manager.controller;

import java.io.IOException;

import org.springframework.validation.BindingResult;

import com.lowagie.text.DocumentException;
import com.sipl.vehicle.manager.dto.UserDto;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.payload.ApiResponse;

public interface VehicleManagerController {

	public ApiResponse<VehicleDto> listVehicle(int pageNumber, int pageSize);

	public  ApiResponse<VehicleDto> createVehicle(VehicleDto vehicleDto);

	public  ApiResponse<VehicleDto>  getVehicleById(int Id);

	public ApiResponse<VehicleDto>   updateVehicle(int Id, VehicleDto vehicleDto);

	public ApiResponse<VehicleDto>  deleteVehicle(int Id);
	
	public  ApiResponse<VehicleDto>  getVehicleByRestTemplate(int Id);
	
	public void exportDataToPDF() throws DocumentException, IOException;
	
	public ApiResponse<UserDto> registerUser(UserDto userDto, BindingResult bindingResult);
	
	public ApiResponse<UserDto> authenticateUser(UserDto userDto, BindingResult bindingResult);

}
