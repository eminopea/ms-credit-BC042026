package com.template.ms_credit.infrastructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.CreditsApi;
import org.openapitools.model.BaseCreateCreditRequest;
import org.openapitools.model.Credit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CreditApiDelegateImpl implements CreditsApi {
    
    @Override
    public Mono<ResponseEntity<Credit>> createCredit(Mono<BaseCreateCreditRequest> baseCreateCreditRequest, ServerWebExchange exchange) {
        return CreditsApi.super.createCredit(baseCreateCreditRequest, exchange);
    }

    @Override
    public Mono<ResponseEntity<Boolean>> hasOverdueDebt(String documentNumber, ServerWebExchange exchange) {
        return CreditsApi.super.hasOverdueDebt(documentNumber, exchange);
    }
}
