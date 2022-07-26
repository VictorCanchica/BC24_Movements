package com.microservice.controller;

import com.microservice.model.CreditMovement;
import com.microservice.model.DebitMovement;
import com.microservice.service.CreditMovementService;
import com.microservice.service.DebitMovementService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/movements")
public class MovementsController {
    private final DebitMovementService debitMovementService;
    private static final String MOVEMENTDEBIT = "debitmovement";
    private final CreditMovementService movementCreditService;
    private static final String MOVEMENTCREDIT = "creditmovement";
    @GetMapping(value = "/debit/allMovements")
    public Flux<DebitMovement> getAllMovementDebits(){
        return debitMovementService.getAllMovementDebit();
    }

    @GetMapping(value = "/debit/{id}")
    public Mono<DebitMovement> getByIdMovementDebit(@PathVariable String id){
        return debitMovementService.getByIdMovementDebit(id);
    }

    @PostMapping(value = "/debit/create")
    @CircuitBreaker(name = MOVEMENTDEBIT, fallbackMethod = "movementdebit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<DebitMovement> createMovementDebit(@RequestBody DebitMovement debitMovement){
        return debitMovementService.createMovementDebit(debitMovement);
    }

    @PutMapping(value = "/debit/update/{id}")
    @CircuitBreaker(name = MOVEMENTDEBIT, fallbackMethod = "movementdebit")
    public Mono<DebitMovement> updateMovementDebit(@PathVariable String id, @RequestBody DebitMovement debitMovement){
        return debitMovementService.updateMovementDebit(id, debitMovement);
    }

    @DeleteMapping(value = "/debit/delete/{id}")
    public Mono<Void> deleteMovementDebit(@PathVariable String id){
        return debitMovementService.deleteMovementDebit(id);
    }

    @GetMapping(value = "/credit/allMovements")
    public Flux<CreditMovement> getAllMovementCredits(){
        return movementCreditService.getAllMovementCredits();
    }

    @GetMapping(value = "/credit/{id}")
    public Mono<CreditMovement> getByIdMovementCredit(@PathVariable String id){
        return movementCreditService.getMovementCreditById(id);
    }

    @PostMapping(value = "/credit/create")
    @CircuitBreaker(name = MOVEMENTCREDIT, fallbackMethod = "movementcredit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreditMovement> createMovementCredit(@RequestBody CreditMovement creditMovement){
        return movementCreditService.createMovementCredit(creditMovement);
    }

    @PutMapping(value = "/credit/update/{id}")
    @CircuitBreaker(name = MOVEMENTCREDIT, fallbackMethod = "movementcredit")
    public Mono<CreditMovement> updateMovementCredit(@PathVariable String id, @RequestBody CreditMovement creditMovement){
        return movementCreditService.updateMovementCredit(id, creditMovement);
    }
    @DeleteMapping(value = "/credit/delete/{id}")
    public Mono<Void> deleteMovementCredit(@PathVariable String id){
        System.out.println("Movimiento de créditos eliminada con Éxito.");
        return movementCreditService.deleteMovementCredit(id);
    }


}