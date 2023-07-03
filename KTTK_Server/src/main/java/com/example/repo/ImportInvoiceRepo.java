package com.example.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.ImportInvoice;

public interface ImportInvoiceRepo extends JpaRepository<ImportInvoice,Integer>{
	ImportInvoice findById(int id);
	List<ImportInvoice> findByDateImportBetweenAndSupplierId(Date dateStart, Date dateEnd, int id);
}
