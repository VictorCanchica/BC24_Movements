package com.microservice.service.impl;

import com.microservice.model.CreditMovement;
import com.microservice.repository.CreditMovementRepository;
import com.microservice.service.CreditMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditMovementServiceImpl implements CreditMovementService {

    @Autowired
    CreditMovementRepository creditMovementRepository;

    @Override
    public Flux<CreditMovement> getAllMovementCredits() {
        return creditMovementRepository.findAll();
    }

    @Override
    public Mono<CreditMovement> getMovementCreditById(String id) {
        return creditMovementRepository.findById(id);
    }

    @Override
    public Mono<CreditMovement> createMovementCredit(CreditMovement creditMovement) {
        return creditMovementRepository.save(creditMovement);
    }

    @Override
    public Mono<CreditMovement> updateMovementCredit(String id, CreditMovement creditMovement) {
        return creditMovementRepository.findById(id).flatMap(creditMovement1 -> {
            creditMovement1.setAmount(creditMovement.getAmount());
            creditMovement1.setDateLimit(creditMovement.getDateLimit());
            creditMovement1.setCommission(creditMovement.getCommission());
            creditMovement1.setDescription(creditMovement.getDescription());
            return creditMovementRepository.save(creditMovement1);
        }).switchIfEmpty(Mono.empty());
    }
    @Override
    public Mono<Void> deleteMovementCredit(String id) {
        return creditMovementRepository.findById(id).flatMap(creditMovement -> creditMovementRepository.deleteById(creditMovement.getId()));
    }
}
