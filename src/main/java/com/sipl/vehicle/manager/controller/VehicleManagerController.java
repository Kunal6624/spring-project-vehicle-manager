package com.sipl.vehicle.manager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.GlobalException;
import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleManagerController {

	public ResponseEntity<List<VehicleDto>> listVehicle() throws GlobalException;

	public ResponseEntity<VehicleDto> createVehicle(VehicleDto vehicleDto) throws GlobalException;

	public  ResponseEntity<VehicleDto>  getVehicleById(int Id) throws GlobalException;

	public ResponseEntity<VehicleDto>  updateVehicle(int Id, VehicleDto vehicleDto) throws GlobalException;

	public ResponseEntity<String>  deleteVehicle(int Id) throws GlobalException;

}
