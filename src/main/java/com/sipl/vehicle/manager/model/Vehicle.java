package com.sipl.vehicle.manager.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "vehicle_registration_number", unique = true)
	private String vehicleRegistrationNumber;
	@Column(name = "owner_name")
	private String ownerName;
	@Column(name = "brand")
	private String brand;
	@Column(name = "registration_expiry_date") 
	private LocalDateTime registrationExpires;
	@Column(name = "active")
	private boolean isActive;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_time")
	@CreationTimestamp
	private LocalDateTime creationTime;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_time")
	@UpdateTimestamp
	private LocalDateTime modifiedTime;
	
}
