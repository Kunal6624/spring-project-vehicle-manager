package com.sipl.vehicle.manager.controller;

import java.util.List;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.payload.ApiResponse;

public interface VehicleManagerController {

	public ApiResponse<List<VehicleDto>> listVehicle();

	public  ApiResponse<VehicleDto> createVehicle(VehicleDto vehicleDto);

	public  ApiResponse<VehicleDto>  getVehicleById(int Id);

	public ApiResponse<VehicleDto>   updateVehicle(int Id, VehicleDto vehicleDto);

	public ApiResponse<String>  deleteVehicle(int Id);

}
