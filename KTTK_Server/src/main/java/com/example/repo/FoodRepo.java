package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {
	List<Food>findByNameContains(String key);
}
