package com.sipl.vehicle.manager.service;

import java.util.List;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.ResourceNotFoundException;
import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerService {

	List<VehicleDto> getAllVehicle();

	VehicleDto getVehicleById(int Id) throws Exception;

	VehicleDto addVehicle(VehicleDto theVehicleDto);

	VehicleDto updateVehicle(VehicleDto theVehicleDto, int id) throws Exception;

	String deleteVehicle(int id);
}
