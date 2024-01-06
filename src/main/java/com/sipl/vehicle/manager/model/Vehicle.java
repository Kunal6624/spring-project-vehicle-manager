package com.sipl.vehicle.manager.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	// default constructor
	public Vehicle() {

	}

	public Vehicle(String vehicleRegistrationNumber, String ownerName, String brand, LocalDateTime registrationExpires,
			boolean isActive, String createdBy, LocalDateTime creationTime, String modifiedBy, LocalDateTime modifiedTime) {
		super();
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.ownerName = ownerName;
		this.brand = brand;
		this.registrationExpires = registrationExpires;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.modifiedBy = modifiedBy;
		this.modifiedTime = modifiedTime;
	}

	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}

	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDateTime getRegistrationExpires() {
		return registrationExpires;
	}

	public void setRegistrationExpires(LocalDateTime registrationExpires) {
		this.registrationExpires = registrationExpires;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

}
