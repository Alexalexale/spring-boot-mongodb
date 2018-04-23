package com.exemplo.springbootmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.springbootmongodb.dto.UserDTO;
import com.exemplo.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "users")
public class UserResource {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> listUsers = userService.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
		return ResponseEntity.ok(listUsers);
	}

}