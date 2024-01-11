package com.sipl.vehicle.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.payload.ApiResponse;
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
	@GetMapping("/vehicle-list/{page_number}/{page_size}")
	public ApiResponse<VehicleDto> listVehicle(@PathVariable("page_number") int pageNumber,
			@PathVariable("page_size") int pageSize) {
		return vehicleManagerService.getAllVehicle(pageNumber, pageSize);

	}

	@Override
	@PostMapping("/add-vehicle")
	public ApiResponse<VehicleDto> createVehicle(@RequestBody VehicleDto theVehicleDto) {
		return vehicleManagerService.addVehicle(theVehicleDto);
	}

	@Override
	@GetMapping("/get-vehicle/{id}")
	public ApiResponse<VehicleDto> getVehicleById(@PathVariable("id") int Id) {
		return vehicleManagerService.getVehicleById(Id);
	}

	@Override
	@PutMapping("/update-vehicle/{id}")
	public ApiResponse<VehicleDto> updateVehicle(@PathVariable("id") int Id, @RequestBody VehicleDto vehicleDto) {
		return vehicleManagerService.updateVehicle(vehicleDto, Id);
	}

	@Override
	@DeleteMapping("/delete-vehicle/{id}")
	public ApiResponse<VehicleDto> deleteVehicle(@PathVariable("id") int Id) {
		return vehicleManagerService.deleteVehicle(Id);
	}
}
