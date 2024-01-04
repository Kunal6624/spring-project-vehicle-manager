package com.sipl.vehicle.manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipl.vehicle.manager.dao.VehicleRepository;
import com.sipl.vehicle.manager.model.Vehicle;

@Service
public class VehicleManagerSeviceImp implements VehicleManagerService {

	private VehicleRepository vehicleRepository;

	@Autowired
	public VehicleManagerSeviceImp(VehicleRepository vehicleRepository) {
		super();
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	@Override
	public Vehicle addVehicle(Vehicle theVehicle) {
		return vehicleRepository.save(theVehicle);
	}

	@Override
	public Vehicle getVehicleById(int Id) {
		Optional<Vehicle> theVehicle = vehicleRepository.findById(Id);
		return theVehicle.get();
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle, int Id) {

		// Check whether the employee exist in DB
		Vehicle existingEmployee = vehicleRepository.findById(Id).orElseThrow();

		existingEmployee.setVehicleRegistrationNumber(vehicle.getVehicleRegistrationNumber());
		existingEmployee.setOwnerName(vehicle.getOwnerName());
		existingEmployee.setBrand(vehicle.getBrand());
		existingEmployee.setRegistrationExpires(vehicle.getRegistrationExpires());
		existingEmployee.setCreatedBy(vehicle.getCreatedBy());
		existingEmployee.setCreationTime(vehicle.getCreationTime());
		existingEmployee.setModifiedBy(vehicle.getModifiedBy());
		existingEmployee.setModifiedTime(vehicle.getModifiedTime());
		existingEmployee.setActive(vehicle.isActive());

		vehicleRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
	}

}
