package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Food;
import com.example.repo.FoodRepo;

@RestController
@RequestMapping("/food")
public class FoodApi {
	@Autowired
	private FoodRepo repo;
	
	@GetMapping("/search")
	private List<Food> searchByKey(@RequestParam(name="key")String key){
		return repo.findByNameContains(key);
	}
}
