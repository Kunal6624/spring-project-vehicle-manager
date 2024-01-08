package com.sipl.vehicle.manager.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class VehicleDto {
	
	@Id
	private int id;
	private String vehicleRegistrationNumber;
	private String ownerName;
	private String brand;
	private LocalDateTime registrationExpires;
	private boolean isActive;
	private String createdBy;
	private String modifiedBy;
}
