package com.microservice.repository;

import com.microservice.model.CreditMovement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditMovementRepository extends ReactiveMongoRepository<CreditMovement, String> {

}
