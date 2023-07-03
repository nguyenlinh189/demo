package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsedFood {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float price;
	private float quantity;
	private String note;
	@Transient
	private float totalMoney;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Food food;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private BookedTable bookedTable;
	
}
