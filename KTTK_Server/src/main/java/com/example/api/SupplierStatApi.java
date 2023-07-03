package com.example.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SupplierStat;
import com.example.repo.SupplierRepo;

@RestController
@RequestMapping("/stat")
public class SupplierStatApi {
	@Autowired
	private SupplierRepo repo;
	@GetMapping
	private List<SupplierStat>getSupplierStat(@RequestParam(name="dateStart")Date dateStart,@RequestParam(name="dateEnd") Date dateEnd){
		List[] stats=repo.getSupplierStats(dateStart, dateEnd);
		List<SupplierStat>list=new ArrayList<>();
		for(List o:stats)
		{
			SupplierStat s=new SupplierStat();
			s.setId(Integer.parseInt(o.get(0).toString()));
			s.setAddress(o.get(1).toString());
			s.setDescription(o.get(2).toString());
			s.setEmail(o.get(3).toString());
			s.setName(o.get(4).toString());
			s.setPhone(o.get(5).toString());
			s.setTotalMoney(Float.parseFloat(o.get(6).toString()));
			s.setTotalQuantity(Float.parseFloat(o.get(7).toString()));
			list.add(s);
		}
		return list;
	}
}
