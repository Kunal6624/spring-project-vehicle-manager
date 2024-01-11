package com.sipl.vehicle.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sipl.vehicle.manager.dao.VehicleRepository;
import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.exception.ResourceNotFoundException;
import com.sipl.vehicle.manager.mapper.VehicleMapper;
import com.sipl.vehicle.manager.model.Vehicle;
import com.sipl.vehicle.manager.payload.ApiResponse;

@Service
public class VehicleManagerSeviceImp implements VehicleManagerService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private VehicleMapper vehicleMapper;

	@Override
	public ApiResponse<VehicleDto> getAllVehicle(int pageNumber, int pageSize) {
		try {
//		Page<Vehicle> vehicles = vehicleRepository.findAll(PageRequest.of(pageNumber, pageSize));
//		System.out.println(vehicles);
//			Page<VehicleDto> vehicleDtoPage = vehicleMapper.mapVehiclePageableToVehicleDtoPageable(vehicles);
			return new ApiResponse<VehicleDto>(null, null, null, "Vehicle List Page", HttpStatus.OK, false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> addVehicle(VehicleDto theVehicleDto) {
		try {
			Vehicle theVehicle = vehicleMapper.mapVehicleDtoToVehicle(theVehicleDto);
			VehicleDto vehicleDto = vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(theVehicle));
			return new ApiResponse<VehicleDto>(vehicleDto, null, null, "Vehicle added successfully", HttpStatus.OK,
					false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> getVehicleById(int Id) {
		try {
			Vehicle theVehicle = vehicleRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

			VehicleDto theVehicleDto = vehicleMapper.mapVehicleToVehicleDto(theVehicle);

			return new ApiResponse<VehicleDto>(theVehicleDto, null, null, "Vehicle Data", HttpStatus.OK, false);
		} catch (ResourceNotFoundException re) {
			return new ApiResponse<VehicleDto>(null, null, null, re.getMessage(), HttpStatus.NOT_FOUND, true);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> updateVehicle(VehicleDto vehicleDto, int Id) {

		try {
			// Check whether the employee exist in DB
			Vehicle existingVehicle = vehicleRepository.findById(Id)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle", "Id", Id));

			existingVehicle.setBrand(vehicleDto.getBrand());
			existingVehicle.setOwnerName(vehicleDto.getOwnerName());
			existingVehicle.setVehicleRegistrationNumber(vehicleDto.getVehicleRegistrationNumber());
			existingVehicle.setRegistrationExpires(vehicleDto.getRegistrationExpires());
			existingVehicle.setCreatedBy(vehicleDto.getCreatedBy());
			existingVehicle.setModifiedBy(vehicleDto.getModifiedBy());

			VehicleDto vehicleDtoObj = vehicleMapper.mapVehicleToVehicleDto(vehicleRepository.save(existingVehicle));
			return new ApiResponse<VehicleDto>(vehicleDtoObj, null, null, "Vehicle Updated successfully", HttpStatus.OK,
					false);
		} catch (ResourceNotFoundException re) {
			return new ApiResponse<VehicleDto>(null, null, null, re.getMessage(), HttpStatus.NOT_FOUND, true);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, true);
		}
	}

	@Override
	public ApiResponse<VehicleDto> deleteVehicle(int id) {
		try {
			vehicleRepository.deleteById(id);
			return new ApiResponse<VehicleDto>(null, null, null, "Vehicle Deleted successfully", HttpStatus.OK, false);
		} catch (Exception e) {
			return new ApiResponse<VehicleDto>(null, null, null, "Internal Server Error", HttpStatus.NOT_FOUND, true);
		}
	}
}
