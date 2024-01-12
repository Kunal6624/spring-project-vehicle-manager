package com.sipl.vehicle.manager.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.model.Vehicle;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

	VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

	Vehicle mapVehicleDtoToVehicle(VehicleDto vehicleDto);

	VehicleDto mapVehicleToVehicleDto(Vehicle vehicle);

	List<VehicleDto> mapVehicleListToVehicleDtoList(List<Vehicle> vehicles);

	// Page<VehicleDto> mapVehiclePageableToVehicleDtoPageable(Page<Vehicle>
	// vehiclePage);

//	@Mapping(target = "offset", source = "offset")
//    @Mapping(target = "pageNumber", source = "pageNumber")
//    @Mapping(target = "pageSize", source = "pageSize")
//  Pageable vehicleDtoPage mapVehiclePageableToVehicleDtoPageable(Pageable VehiclePage);

	default Page<VehicleDto> mapVehiclePageToVehilceDtoPage(Page<Vehicle> vehiclePageFetchedFromDb) {
		return vehiclePageFetchedFromDb.map(pageEntity -> mapVehicleToVehicleDto(pageEntity));
	}

}
