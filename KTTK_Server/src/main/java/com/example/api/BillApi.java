package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Bill;
import com.example.model.BookedTable;
import com.example.model.UsedFood;
import com.example.repo.BillRepo;
import com.example.repo.BookedTableRepo;
import com.example.repo.UsedFoodRepo;

@RestController
@RequestMapping("/bill")
public class BillApi {
	@Autowired
	private BillRepo billrepo;
	@Autowired
	private BookedTableRepo bookrepo;
	@Autowired
	private UsedFoodRepo usedRepo;
	@PostMapping("/save")
	private Bill saveBill(@RequestBody Bill bill) {
		BookedTable b=bill.getBookedTable();
		for(UsedFood f:bill.getBookedTable().getListUsedFood())
			f.setBookedTable(b);
		// danh sach usedfood trc khi thanh toans
		List<UsedFood>list=usedRepo.findByBookedTableId(b.getId());
		// danh sach usedfood khi thanh toan
		List<UsedFood>list1=b.getListUsedFood();
		for(UsedFood f:list) {
			int mark=0;
			for(UsedFood f1:list1) {
				if(f.getId()==f1.getId()) {
					mark=1;
					break;
				}
			}
			if(mark==0)
				usedRepo.delete(f.getId());
		}
		bookrepo.save(bill.getBookedTable());
		return billrepo.save(bill);
	}
}
