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
import com.example.rest.model.DeliveryBoy;
import com.example.rest.service.DeliveryBoyService;

@RestController
public class DeliveryBoyController {

	@Autowired
	private DeliveryBoyService deliveryBoyService;

	@GetMapping(value = "/deliveryBoy")
	@ResponseBody
	public ResponseEntity<List<DeliveryBoy>> getAll() {
		return deliveryBoyService.getAll();
	}

	@GetMapping(value = "/deliveryBoy/{id}")
	@ResponseBody
	public ResponseEntity<DeliveryBoy> findById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		return deliveryBoyService.findById(id);
	}

	@PostMapping(value = "/deliveryBoy")
	@ResponseBody
	public ResponseEntity<DeliveryBoy> save(@RequestBody DeliveryBoy deliveryBoy) {
		return deliveryBoyService.save(deliveryBoy);
	}
	
	@PostMapping(value = "/deliveryBoyList")
	@ResponseBody
	public ResponseEntity<List<DeliveryBoy>> saveList(@RequestBody List<DeliveryBoy> deliveryBoy) {
		return deliveryBoyService.saveList(deliveryBoy);
	}

	@PutMapping(value = "/deliveryBoy/{id}")
	@ResponseBody
	public ResponseEntity<DeliveryBoy> update(@PathVariable(value = "id") long id, @RequestBody DeliveryBoy deliveryBoy)
			throws ResourceNotFoundException {

		return deliveryBoyService.update(id, deliveryBoy);
	}
	
	@DeleteMapping(value = "/deliveryBoy/{id}")
	Map<String, Boolean> delete(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		return deliveryBoyService.delete(id);
	}
	
	
	

}
