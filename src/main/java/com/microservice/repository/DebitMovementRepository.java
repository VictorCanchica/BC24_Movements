package com.microservice.repository;

import com.microservice.model.DebitMovement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DebitMovementRepository extends ReactiveMongoRepository<DebitMovement, String> {

}
