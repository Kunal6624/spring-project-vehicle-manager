package com.sipl.vehicle.manager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerController {

	public ResponseEntity<List<VehicleDto>> listVehicle();

	public ResponseEntity<VehicleDto> createVehicle(VehicleDto vehicleDto);

	public  ResponseEntity<VehicleDto>  getVehicleById(int Id);

	public ResponseEntity<VehicleDto>  updateVehicle(int Id, VehicleDto vehicleDto);

	public ResponseEntity<String>  deleteVehicle(int Id);

}
