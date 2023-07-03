package com.example.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Ingredient;
import com.example.repo.IngredientRepo;

@RestController
@RequestMapping("/ingredient")
public class IngredientApi {
	@Autowired
	private IngredientRepo repo;
	
	@GetMapping("/search")
	private List<Ingredient> search(@RequestParam(name="key")String key) {
		List<Ingredient>list=new ArrayList<>();
		list=repo.findByNameContains(key);
		return list;
	}
	@PostMapping("/add")
	private Ingredient add(@RequestBody Ingredient ingredient)
	{
		return repo.save(ingredient);
	}
}
