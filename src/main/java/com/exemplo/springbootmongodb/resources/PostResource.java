package com.exemplo.springbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.springbootmongodb.domain.Post;
import com.exemplo.springbootmongodb.resources.util.URL;
import com.exemplo.springbootmongodb.services.PostService;

@RestController
@RequestMapping(value = "posts")
public class PostResource {

	@Autowired
	private PostService postService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post user = postService.findbyId(id);
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/title")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
		List<Post> posts = postService.findByTitle(URL.decode(text));
		return ResponseEntity.ok(posts);
	}
}