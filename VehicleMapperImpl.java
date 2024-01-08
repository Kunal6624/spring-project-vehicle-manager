package com.sipl.vehicle.manager.mapper;

import com.sipl.vehicle.manager.dto.VehicleDto;
import com.sipl.vehicle.manager.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Eclipse Adoptium)"
)
*/
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle mapVehicleDtoToVehicle(VehicleDto vehicleDto) {
        if ( vehicleDto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.set( vehicleDto.getId() );
        vehicle.setVehicleRegistrationNumber( vehicleDto.getVehicleRegistrationNumber() );
        vehicle.setOwnerName( vehicleDto.getOwnerName() );
        vehicle.setBrand( vehicleDto.getBrand() );
        vehicle.setRegistrationExpires( vehicleDto.getRegistrationExpires() );
        vehicle.setActive( vehicleDto.isActive() );
        vehicle.setCreatedBy( vehicleDto.getCreatedBy() );
        vehicle.setModifiedBy( vehicleDto.getModifiedBy() );

        return vehicle;
    }

    @Override
    public VehicleDto mapVehicleToVehicleDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setVehicleRegistrationNumber( vehicle.getVehicleRegistrationNumber() );
        vehicleDto.setOwnerName( vehicle.getOwnerName() );
        vehicleDto.setBrand( vehicle.getBrand() );
        vehicleDto.setRegistrationExpires( vehicle.getRegistrationExpires() );
        vehicleDto.setActive( vehicle.isActive() );
        vehicleDto.setCreatedBy( vehicle.getCreatedBy() );
        vehicleDto.setModifiedBy( vehicle.getModifiedBy() );

        return vehicleDto;
    }

    @Override
    public List<VehicleDto> mapVehicleListToVehicleDtoList(List<Vehicle> vehicles) {
        if ( vehicles == null ) {
            return null;
        }

        List<VehicleDto> list = new ArrayList<VehicleDto>( vehicles.size() );
        for ( Vehicle vehicle : vehicles ) {
            list.add( mapVehicleToVehicleDto( vehicle ) );
        }

        return list;
    }
}
