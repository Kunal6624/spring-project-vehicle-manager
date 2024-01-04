package com.sipl.vehicle.manager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerController {

	public ResponseEntity<List<Vehicle>> listVehicle();

	public ResponseEntity<Vehicle> createVehicle(Vehicle theVehicle);

	public  ResponseEntity<Vehicle>  getVehicleById(int Id);

	public ResponseEntity<Vehicle>  updateVehicle(int Id, Vehicle theVehicle);

	public ResponseEntity<String>  deleteVehicle(int Id);

}
