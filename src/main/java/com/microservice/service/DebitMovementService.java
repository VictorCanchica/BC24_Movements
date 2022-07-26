package com.microservice.service;

import com.microservice.model.DebitMovement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitMovementService {

    Flux<DebitMovement> getAllMovementDebit();
    Mono<DebitMovement> getByIdMovementDebit(String id);
    Mono<DebitMovement> createMovementDebit(DebitMovement debitMovement);
    Mono<DebitMovement> updateMovementDebit(String id, DebitMovement debitMovement);
    Mono<Void> deleteMovementDebit(String id);

}
