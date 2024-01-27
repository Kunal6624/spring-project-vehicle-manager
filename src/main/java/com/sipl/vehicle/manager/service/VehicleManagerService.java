package com.sipl.vehicle.manager.service;

import com.sipl.vehicle.manager.dto.UserDto;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.payload.ApiResponse;

public interface VehicleManagerService {

	ApiResponse<VehicleDto> getAllVehicle(int pageNumber, int pageSize);

	ApiResponse<VehicleDto> getVehicleById(int Id);

	ApiResponse<VehicleDto> addVehicle(VehicleDto theVehicleDto);

	ApiResponse<VehicleDto> updateVehicle(VehicleDto theVehicleDto, int id);

	ApiResponse<VehicleDto> deleteVehicle(int id);
	
	ApiResponse<VehicleDto> getVehicleByRestTemplate(int Id);
	
	void exportDataToPDF();
	
	ApiResponse<UserDto> registerUser(UserDto userDto);
	
	ApiResponse<UserDto> auntenticateUser(UserDto userDto);
	
}
