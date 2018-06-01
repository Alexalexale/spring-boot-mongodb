package com.exemplo.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exemplo.springbootmongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}