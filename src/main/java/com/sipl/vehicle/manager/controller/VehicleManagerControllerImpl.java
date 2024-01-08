package com.sipl.vehicle.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.GlobalException;
import com.sipl.vehicle.manager.model.Vehicle;
import com.sipl.vehicle.manager.service.VehicleManagerService;

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
	@GetMapping("/vehicle-list")
	public ResponseEntity<List<VehicleDto>> listVehicle() throws GlobalException {
		try {
			return new ResponseEntity<List<VehicleDto>>(vehicleManagerService.getAllVehicle(), HttpStatus.OK);
		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	@PostMapping("/add-vehicle")
	public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto theVehicleDto) throws GlobalException {
		try {
			return new ResponseEntity<VehicleDto>(vehicleManagerService.addVehicle(theVehicleDto), HttpStatus.CREATED);
		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	@GetMapping("/get-vehicle/{id}")
	public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") int Id) throws GlobalException {
		try {
			return new ResponseEntity<VehicleDto>(vehicleManagerService.getVehicleById(Id), HttpStatus.OK);
		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	@PutMapping("/update-vehicle/{id}")
	public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") int Id, @RequestBody VehicleDto vehicleDto) throws GlobalException {
		try {
			return new ResponseEntity<VehicleDto>(vehicleManagerService.updateVehicle(vehicleDto, Id), HttpStatus.OK);
		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
	}

	@Override
	@DeleteMapping("/delete-vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") int Id) throws GlobalException {
		try {
		String isDeleted = vehicleManagerService.deleteVehicle(Id);
		return new ResponseEntity<String>(isDeleted, HttpStatus.OK);
		} catch (Exception e) {
			throw new GlobalException(e.getMessage());
		}
		}
	
}
