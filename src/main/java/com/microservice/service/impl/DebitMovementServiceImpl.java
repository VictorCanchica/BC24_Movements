package com.microservice.service.impl;

import com.microservice.model.DebitMovement;
import com.microservice.repository.DebitMovementRepository;
import com.microservice.service.DebitMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitMovementServiceImpl implements DebitMovementService {

    @Autowired
    DebitMovementRepository debitMovementRepository;

    @Override
    public Flux<DebitMovement> getAllMovementDebit() {
        return debitMovementRepository.findAll();
    }

    @Override
    public Mono<DebitMovement> getByIdMovementDebit(String id) {
        return debitMovementRepository.findById(id);
    }

    @Override
    public Mono<DebitMovement> createMovementDebit(DebitMovement debitMovement) {
        return debitMovementRepository.save(debitMovement);
    }

    @Override
    public Mono<DebitMovement> updateMovementDebit(String id, DebitMovement debitMovement) {
        return debitMovementRepository.findById(id).flatMap(debitMovement1 -> {
            debitMovement1.setAmount(debitMovement.getAmount());
            debitMovement1.setDateLimit(debitMovement.getDateLimit());
            debitMovement1.setCommission(debitMovement.getCommission());
            debitMovement1.setDescription(debitMovement.getDescription());
            return debitMovementRepository.save(debitMovement1);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> deleteMovementDebit(String id) {
        return debitMovementRepository.findById(id).flatMap(debitMovement -> debitMovementRepository.deleteById(debitMovement.getId()));
    }
}
