package com.example.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportInvoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Transient // de khong tao thuoc tinh trong csdl
	private float totalMoney;
	@Transient
	private float totalQuantity;
	private String note;
	private Date dateImport;
	@OneToMany(mappedBy = "importInvoice",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<DetailInvoice>listDetailInvoice=new ArrayList<>();
	@ManyToOne(cascade = CascadeType.MERGE)
	private Supplier supplier;
	public ImportInvoice(float totalMoney, float totalQuantity, String note, Date dateImport,
			List<DetailInvoice> listDetailInvoice, Supplier supplier) {
		super();
		this.totalMoney = totalMoney;
		this.totalQuantity = totalQuantity;
		this.note = note;
		this.dateImport = dateImport;
		this.listDetailInvoice = listDetailInvoice;
		this.supplier = supplier;
	}
	
}
