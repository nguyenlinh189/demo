package com.example.api;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DetailInvoice;
import com.example.model.ImportInvoice;
import com.example.model.Ingredient;
import com.example.repo.ImportInvoiceRepo;
import com.example.repo.IngredientRepo;

@RestController
@RequestMapping("/invoice")
public class ImportInvoiceApi {
	@Autowired
	private ImportInvoiceRepo repo;
	@Autowired
	private IngredientRepo ingreRepo;
	@PostMapping("/save")
	private ImportInvoice saveinvoice(@RequestBody ImportInvoice invoice) {
		for(DetailInvoice detail:invoice.getListDetailInvoice())
		{
			detail.setImportInvoice(invoice);
			ingreRepo.updateIngredient(detail.getQuantity(), detail.getIngredient().getId());
		}
		return repo.save(invoice);
	}
//	@GetMapping("/get")
//	private ImportInvoice getinvoice() {
//		return repo.findById(15);
//		
//	}
	@GetMapping("/getStat")
	private List<ImportInvoice> getStat(@RequestParam(name="dateStart")Date dateStart,@RequestParam(name="dateEnd") Date dateEnd,
			@RequestParam(name="idSup")int id){
		List<ImportInvoice>list=repo.findByDateImportBetweenAndSupplierId(dateStart, dateEnd,id);
		for(ImportInvoice invoice:list)
		{
			float totalMoney=0;
			float totalQuantity=0;
			for(DetailInvoice detail:invoice.getListDetailInvoice())
			{
				detail.setTotalMoney(detail.getQuantity()*detail.getUnitPrice());
				totalMoney+=detail.getTotalMoney();
				totalQuantity+=detail.getQuantity();
			}
			invoice.setTotalMoney(totalMoney);
			invoice.setTotalQuantity(totalQuantity);
		}
		return list;
	}
}
