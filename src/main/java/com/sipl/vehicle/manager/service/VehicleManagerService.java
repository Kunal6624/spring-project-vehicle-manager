package com.sipl.vehicle.manager.service;

import java.util.List;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerService {

	List<VehicleDto> getAllVehicle();

	VehicleDto getVehicleById(int Id);

	VehicleDto addVehicle(VehicleDto theVehicleDto);

	VehicleDto updateVehicle(VehicleDto theVehicleDto, int id);

	String deleteVehicle(int id);
}
