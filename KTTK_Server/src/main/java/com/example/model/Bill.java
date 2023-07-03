package com.example.model;

import java.sql.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String paymentDate;
	private String paymentType;
	private String note;
	@Transient
	private float totalMoney;
	@OneToOne(cascade = CascadeType.MERGE)
	private BookedTable bookedTable;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="idStaff")
	private User staff;
}
