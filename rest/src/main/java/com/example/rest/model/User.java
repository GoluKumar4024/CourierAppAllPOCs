package com.example.rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="test")
public class User {
	
	
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private long userId;
	
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	
	
	
	
}
