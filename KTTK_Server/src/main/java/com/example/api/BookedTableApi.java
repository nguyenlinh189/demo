package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookedTable;
import com.example.model.UsedFood;
import com.example.repo.BookedTableRepo;

@RestController
@RequestMapping("/booked")
public class BookedTableApi {
	@Autowired
	private BookedTableRepo repo;
	
	@GetMapping("/getListBookedTableUnpaid")
	private List<BookedTable>getListUnpaid(@RequestParam(name="key")String key){
		List<BookedTable>list= repo.findByFurnitureNameContainsAndIspaymentFalse(key);
		for(BookedTable b:list) {
			float totalMoney=0;
			float totalQuantity=0;
			for(UsedFood f:b.getListUsedFood()) {
				f.setTotalMoney(f.getQuantity()*f.getPrice());
				totalMoney+=f.getTotalMoney();
				totalQuantity+=f.getQuantity();
			}
			b.setTotalMoney(totalMoney);
			b.setTotalQuantity(totalQuantity);
		}
		return list;
	}
}
