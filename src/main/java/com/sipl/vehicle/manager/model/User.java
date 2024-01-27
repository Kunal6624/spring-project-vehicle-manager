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
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	@Column(name = "user_name")
	private String name;
	private String password;
	@Column(unique = true)
	private String email;
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
