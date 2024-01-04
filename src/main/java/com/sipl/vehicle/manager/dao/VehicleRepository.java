package com.sipl.vehicle.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipl.vehicle.manager.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
