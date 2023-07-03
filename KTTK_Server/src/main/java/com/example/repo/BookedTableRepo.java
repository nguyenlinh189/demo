package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.BookedTable;

public interface BookedTableRepo extends JpaRepository<BookedTable, Integer> {
	// lấy danh sách theo tên và chưa thanh toán
	List<BookedTable> findByFurnitureNameContainsAndIspaymentFalse(String key);
}
