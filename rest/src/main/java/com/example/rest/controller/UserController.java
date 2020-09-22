package com.example.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.model.User;
import com.example.rest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// add a user
	@PostMapping(path = "/users", consumes = "application/json")
	@ResponseBody
	ResponseEntity<User> addUser(@RequestBody User user) {
		// System.out.println(user);
		return userService.addUser(user);
	}

	// get all users
	@GetMapping(path = "/users", produces = "application/json")
	@ResponseBody
	ResponseEntity<List<User>> getAllUsers() {
		return userService.getAllUsers();
	}

	// get user with id={userId}
	@GetMapping(path = "/users/{userId}", produces = "application/json")
	@ResponseBody
	ResponseEntity<User> getUserById(@PathVariable(value = "userId") long userId) throws ResourceNotFoundException {
		return userService.getUserById(userId);
	}

	// update user with id={userId} by userDetails
	@PutMapping(value = "/users/{userId}")
	@ResponseBody
	ResponseEntity<User> updateUser(@PathVariable(value = "userId") long userId, @RequestBody User userDetails)
			throws ResourceNotFoundException {
		return userService.updateUser(userId, userDetails);
	}

	@DeleteMapping(value = "/users/{userId}")
	Map<String, Boolean> deleteUser(@PathVariable(value = "userId") long userId) throws ResourceNotFoundException {
		return userService.deleteUser(userId);
	}

}
