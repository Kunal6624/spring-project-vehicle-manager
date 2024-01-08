package com.sipl.vehicle.manager.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.model.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
	
	VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
	
	Vehicle mapVehicleDtoToVehicle(VehicleDto vehicleDto);

	VehicleDto mapVehicleToVehicleDto(Vehicle vehicle);

	List<VehicleDto> mapVehicleListToVehicleDtoList(List<Vehicle> vehicles);
}
