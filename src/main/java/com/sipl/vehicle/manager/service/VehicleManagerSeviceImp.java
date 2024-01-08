package com.sipl.vehicle.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipl.vehicle.manager.dao.VehicleRepository;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.ResourceNotFoundException;
import com.sipl.vehicle.manager.mapper.VehicleMapper;
import com.sipl.vehicle.manager.model.Vehicle;

@Service
public class VehicleManagerSeviceImp implements VehicleManagerService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public List<VehicleDto> getAllVehicle() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		System.out.println(vehicles);
		return vehicleMapper.mapVehicleListToVehicleDtoList(vehicles);
	}

	@Override
	public VehicleDto addVehicle(VehicleDto theVehicleDto) {
		Vehicle theVehicle = vehicleMapper.mapVehicleDtoToVehicle(theVehicleDto);
		return vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(theVehicle));
	}

	@Override
	public VehicleDto getVehicleById(int Id) throws Exception {
		Vehicle theVehicle = vehicleRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

		return vehicleMapper.mapVehicleToVehicleDto(theVehicle);
	}

	@Override
	public VehicleDto updateVehicle(VehicleDto vehicleDto, int Id) throws Exception {

		// Check whether the employee exist in DB
		Vehicle existingVehicle = vehicleRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

		existingVehicle.setBrand(vehicleDto.getBrand());
		existingVehicle.setOwnerName(vehicleDto.getOwnerName());
		existingVehicle.setVehicleRegistrationNumber(vehicleDto.getVehicleRegistrationNumber());
		existingVehicle.setRegistrationExpires(vehicleDto.getRegistrationExpires());
		existingVehicle.setCreatedBy(vehicleDto.getCreatedBy());
		existingVehicle.setModifiedBy(vehicleDto.getModifiedBy());

		return vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(existingVehicle));

	}

	@Override
	public String deleteVehicle(int id) {
		vehicleRepository.deleteById(id);
		return "Vehicle Deleted Sucessfully";
	}


}
