package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String description;
	public Supplier(String name, String address, String phone, String email, String description) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.description = description;
	}
	
}
