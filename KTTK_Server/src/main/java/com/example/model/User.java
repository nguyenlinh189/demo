package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String email;
	private String username;
	private String password;
	private String role;
	public User(String name, String address, String email, String username, String password, String role) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
