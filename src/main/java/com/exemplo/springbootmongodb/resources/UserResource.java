package com.exemplo.springbootmongodb.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.springbootmongodb.domain.User;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User ale = new User("1", "Alessandro", "ale@gmail.com");
		User alex = new User("1", "Alex", "alex@gmail.com");
		List<User> listUsers = Arrays.asList(ale, alex);
		return ResponseEntity.ok(listUsers);
	}

}