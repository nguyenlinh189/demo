package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierStat extends Supplier{
	private float totalQuantity;
	private float totalMoney;
	public SupplierStat(String name, String address, String phone, String email, String description,
			float totalQuantity, float totalMoney) {
		super(name, address, phone, email, description);
		this.totalQuantity = totalQuantity;
		this.totalMoney = totalMoney;
	}
}
