package com.example.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookedTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String checkIn;
	private String checkOut;
	private String note;
	private boolean ispayment;
	@Transient
	private float totalMoney;
	@Transient
	private float totalQuantity;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Furniture furniture;
	@OneToMany(mappedBy = "bookedTable", cascade = CascadeType.ALL)
	private List<UsedFood>listUsedFood=new ArrayList<>();
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idCustomer")
	private User customer;
}
