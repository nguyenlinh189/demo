package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Ingredient;

import jakarta.transaction.Transactional;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer>{
	Ingredient findById(int id);
	List<Ingredient> findByNameContains(String key);
	@Modifying
	@Transactional
	@Query(value = "update ingredient set quantity=quantity+? where id=?", nativeQuery = true)
	void updateIngredient(float quantity, int id);
}
