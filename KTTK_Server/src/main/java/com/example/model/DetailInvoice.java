package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DetailInvoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float unitPrice;
	private float quantity;
	@Transient
	private float totalMoney;
	private String note;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Ingredient ingredient;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private ImportInvoice importInvoice;
	public DetailInvoice(float unitPrice, float quantity, String note, Ingredient ingredient) {
		super();
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.note = note;
		this.ingredient = ingredient;
	}	
}
