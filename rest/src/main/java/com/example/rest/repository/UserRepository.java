package com.example.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rest.model.User;

public interface UserRepository extends MongoRepository<User,Long>{

}
