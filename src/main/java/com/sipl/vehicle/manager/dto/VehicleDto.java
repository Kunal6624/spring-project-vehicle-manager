package com.sipl.vehicle.manager.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VehicleDto {
	
	
	private int id;
	private String vehicleRegistrationNumber;
	private String ownerName;
	private String brand;
	private LocalDateTime registrationExpires;
	private boolean isActive;
	private String createdBy;
	private LocalDateTime creationTime;
	private String modifiedBy;
	private LocalDateTime modifiedTime;

}
