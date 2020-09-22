package com.example.rest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.model.User;
import com.example.rest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DataBaseSequenceService databaseSequenceService;

	private Object mongoTemplate;

	public ResponseEntity<User> addUser(User user) {

		user.setUserId(databaseSequenceService.generateSequence(User.SEQUENCE_NAME));

		HttpHeaders header = new HttpHeaders();
		header.add("first_desc", "custom Header");
		header.add("second_desc", "sent by Golu Kumar backends");

		User savedUser = userRepository.save(user);

		// return new ResponseEntity<User>(savedUser, header, HttpStatus.OK);
		/*
		 * we can perform below action by constructor also as commented just above!!!
		 * adding header and constructing whole responseEntity is not necessary But I am
		 * doing so to remember the no of ways we can build the response to be sent WE
		 * CAN DO SOMETHIG VERY BASIC LIKE:ResponseEntity.ok().body(users)
		 */
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(savedUser);

	}

	public ResponseEntity<List<User>> getAllUsers() {

		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);

	}

	public ResponseEntity<User> getUserById(long userId) throws ResourceNotFoundException {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user with given id  not found"));
		return ResponseEntity.ok().body(user);

	}

	public ResponseEntity<User> updateUser(long userId, User userDetails) throws ResourceNotFoundException {
		User user=userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("user to be updated not found"));
		
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		
		final User updatedUser=userRepository.save(user);
		
		
		return ResponseEntity.ok().body(updatedUser);

	}

	public Map<String, Boolean> deleteUser(long userId) throws ResourceNotFoundException {
		User user=userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("user to be deleted not found"));
		userRepository.delete(user);
		Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

}
