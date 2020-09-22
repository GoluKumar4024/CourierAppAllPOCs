package com.example.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.model.DeliveryBoy;


@Repository
public interface DeliveryBoyRepository extends MongoRepository<DeliveryBoy, Long>{

}
