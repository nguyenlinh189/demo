package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.UsedFood;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

public interface UsedFoodRepo extends JpaRepository<UsedFood, Integer>{
	List<UsedFood> findByBookedTableId(int id);
	@Modifying
	@Transactional
	@Query(value = "delete from used_food where id=?", nativeQuery = true)
	void delete(int id);
}
