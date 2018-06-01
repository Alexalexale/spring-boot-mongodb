package com.exemplo.springbootmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.springbootmongodb.domain.Post;
import com.exemplo.springbootmongodb.repository.PostRepository;
import com.exemplo.springbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findbyId(String id) {
		return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado."));
	}

}