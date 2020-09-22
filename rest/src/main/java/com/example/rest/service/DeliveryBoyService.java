package com.example.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.rest.exception.ResourceNotFoundException;
import com.example.rest.model.DeliveryBoy;
import com.example.rest.model.User;
import com.example.rest.repository.DeliveryBoyRepository;

@Service
public class DeliveryBoyService {

	@Autowired
	private DeliveryBoyRepository delieveryBoyRepository;

	@Autowired
	private DataBaseSequenceService databaseSequenceService;

	/* GET ALL */
	public ResponseEntity<List<DeliveryBoy>> getAll() {
		return ResponseEntity.ok().body(delieveryBoyRepository.findAll());
	}

	/* GET BY ID */
	public ResponseEntity<DeliveryBoy> findById(long id) throws ResourceNotFoundException {
		DeliveryBoy deliveryBoy = delieveryBoyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Delivery Boy with given Id not found"));
		return ResponseEntity.ok().body(deliveryBoy);

	}

	/* POST */
	public ResponseEntity<DeliveryBoy> save(DeliveryBoy deliveryBoy) {
		deliveryBoy.setId(databaseSequenceService.generateSequence(DeliveryBoy.SEQUENCE_NAME));
		DeliveryBoy savedDeliveryBoy = delieveryBoyRepository.save(deliveryBoy);
		return ResponseEntity.ok().body(savedDeliveryBoy);
	}
	
	
	// for serving POST LIST
	public DeliveryBoy saveOnly(DeliveryBoy deliveryBoy) {
		deliveryBoy.setId(databaseSequenceService.generateSequence(DeliveryBoy.SEQUENCE_NAME));
		DeliveryBoy savedDeliveryBoy = delieveryBoyRepository.save(deliveryBoy);
		return savedDeliveryBoy;
	}
	
	// POST LIST
	public ResponseEntity<List<DeliveryBoy>> saveList(List<DeliveryBoy> deliveryBoyList){	
		List<DeliveryBoy> savedDeliveryBoyList=
					deliveryBoyList.stream().map(deliveryBoy->saveOnly(deliveryBoy))
								   .collect(Collectors.toList());
		return ResponseEntity.ok().body(savedDeliveryBoyList);
		
	}

	/* PUT/UPDATE BY ID */
	public ResponseEntity<DeliveryBoy> update(long id, DeliveryBoy deliveryBoyDetails)
			throws ResourceNotFoundException {
		DeliveryBoy deliveryBoy = delieveryBoyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user to be updated not found"));

		deliveryBoy.setFirstName(deliveryBoyDetails.getFirstName());
		deliveryBoy.setLastName(deliveryBoyDetails.getLastName());
		deliveryBoy.setAddress(deliveryBoyDetails.getAddress());
		deliveryBoy.setPhone(deliveryBoyDetails.getPhone());
		deliveryBoy.setUserId(deliveryBoyDetails.getUserId());
		deliveryBoy.setPassword(deliveryBoyDetails.getPassword());

		DeliveryBoy updatedDeliveryBoy = delieveryBoyRepository.save(deliveryBoy);
		return ResponseEntity.ok().body(updatedDeliveryBoy);
	}

	/* DELETE */
	public Map<String, Boolean> delete(long id) throws ResourceNotFoundException {
		DeliveryBoy deliveryBoy = delieveryBoyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user to be deleted not found"));
		delieveryBoyRepository.delete(deliveryBoy);
		Map<String, Boolean> response = new HashMap<>();
		response.put("respective delivery Boy is removed", Boolean.TRUE);
		return response;
	}

}
