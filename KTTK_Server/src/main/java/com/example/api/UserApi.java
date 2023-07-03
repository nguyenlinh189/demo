package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserApi {
	@Autowired
	private UserRepo repo;
	@PostMapping("/checklogin")
	private User checkLogin(@RequestBody User user) {
		return repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}
