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

//	@Override
//	@GetMapping("/vehicle-list")
//	public List<Vehicle> listVehicle() {
//		List<Vehicle> theVehicles = vehicleManagerService.getAllVehicle();
//		return theVehicles;
	//}
	
	@Override
	@GetMapping("/vehicle-list")
	public ResponseEntity<List<Vehicle>> listVehicle() {
		return new ResponseEntity<List<Vehicle>>(vehicleManagerService.getAllVehicle(), HttpStatus.OK);

	}

//	@Override
//	@PostMapping("/add-vehicle")
//	public Vehicle createVehicle(@RequestBody Vehicle theVehicle) {
//		Vehicle vehicleObj = vehicleManagerService.addVehicle(theVehicle);
//		return vehicleObj;
//	}
//	

	@Override
	@PostMapping("/add-vehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle theVehicle) {
		return new ResponseEntity<Vehicle>(vehicleManagerService.addVehicle(theVehicle), HttpStatus.CREATED);
	}

	@Override
	@GetMapping("/get-vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int Id) {
		return new ResponseEntity<Vehicle>(vehicleManagerService.getVehicleById(Id), HttpStatus.OK);
	}

	@Override
	@PutMapping("/update-vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int Id, @RequestBody Vehicle theVehicle) {
		return new ResponseEntity<Vehicle>(vehicleManagerService.updateVehicle(theVehicle, Id), HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/delete-vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("id") int Id) {
		vehicleManagerService.deleteVehicle(Id);
		return new ResponseEntity<String>("Vehicle Deleted Successfully", HttpStatus.OK);
	}

}
