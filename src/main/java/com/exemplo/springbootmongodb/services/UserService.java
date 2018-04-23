package com.exemplo.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.springbootmongodb.domain.User;
import com.exemplo.springbootmongodb.repository.UserRepository;
import com.exemplo.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findbyId(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

}