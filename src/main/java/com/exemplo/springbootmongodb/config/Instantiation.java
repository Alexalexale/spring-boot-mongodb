package com.exemplo.springbootmongodb.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.exemplo.springbootmongodb.domain.Post;
import com.exemplo.springbootmongodb.domain.User;
import com.exemplo.springbootmongodb.repository.PostRepository;
import com.exemplo.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Post p1 = new Post(null, new Date(), "Partiu Viagem", "Vou viajar", maria);
		Post p2 = new Post(null, new Date(), "Partiu Viagem2", "Vou viajar", maria);
		Post p3 = new Post(null, new Date(), "Partiu Viagem3", "Vou viajar", alex);

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(p1, p2, p3));

	}

}