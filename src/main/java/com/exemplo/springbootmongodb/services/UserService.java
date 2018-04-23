package com.exemplo.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.springbootmongodb.domain.User;
import com.exemplo.springbootmongodb.dto.UserDTO;
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

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User fromDto(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getNome(), userDTO.getEmail());
	}

	public void delete(String id) {
		findbyId(id);
		userRepository.deleteById(id);
	}

	public User update(User user) {
		User newUser = findbyId(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setNome(user.getNome());
		newUser.setEmail(user.getEmail());
	}
}