package com.sipl.vehicle.manager.service;

import java.util.List;

import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerService {

	List<Vehicle> getAllVehicle();

	Vehicle getVehicleById(int Id);

	Vehicle addVehicle(Vehicle theVehicle);

	Vehicle updateVehicle(Vehicle vehicle, int id);

	void deleteVehicle(int id);
}
