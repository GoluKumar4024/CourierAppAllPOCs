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
@Document(collection = "deliveryBoy")
public class DeliveryBoy {

	public static final String SEQUENCE_NAME = "deliverBoy_sequence";

	@Id
	private long id;

	private String firstName;
	private String lastName;
	private Address address;
	private String phone;
	private String userId;
	private String password;
}
