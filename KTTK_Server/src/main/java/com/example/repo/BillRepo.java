package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer>{

}
