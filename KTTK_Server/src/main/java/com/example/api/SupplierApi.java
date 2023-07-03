package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Supplier;
import com.example.repo.SupplierRepo;

@RestController
@RequestMapping("/supplier")
public class SupplierApi {
	@Autowired
	private SupplierRepo repo;
	
	@GetMapping("/search")
	private List<Supplier> search(@RequestParam(name="key")String key){
		return repo.findByNameContains(key);
	}
	@PostMapping("/add")
	private Supplier add(@RequestBody Supplier supplier) {
		return repo.save(supplier);
	}
	@DeleteMapping("/delete")
	private void delete(@RequestParam(name="id")int id) {
		repo.deleteById(id);
	}
}
