package com.microservice.service;

import com.microservice.model.CreditMovement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditMovementService {

    Flux<CreditMovement> getAllMovementCredits();
    Mono<CreditMovement> getMovementCreditById(String id);
    Mono<CreditMovement> createMovementCredit(CreditMovement creditMovement);
    Mono<CreditMovement> updateMovementCredit(String id, CreditMovement creditMovement);
    Mono<Void> deleteMovementCredit(String id);

}
