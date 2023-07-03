package com.example.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Supplier;
import com.example.model.SupplierStat;

public interface SupplierRepo extends JpaRepository<Supplier,Integer> {
	List<Supplier>findByNameContains(String key);
	@Query(value = "select a.*, sum(b.unit_price*b.quantity) as 'totalMoney', sum(b.quantity) as 'totalQuantity'\r\n"
			+ "from supplier as a, detail_invoice as b, import_invoice as c\r\n"
			+ "where a.id=c.supplier_id and c.id=b.import_invoice_id\r\n"
			+ "and c.date_import>= ? and c.date_import<=?\r\n"
			+ "group by a.id\r\n"
			+ "order by totalQuantity desc, totalMoney desc", nativeQuery = true)
	List[] getSupplierStats(Date dateStart, Date dateEnd);
}
