package com.example.pruebaTZ.useCases.sales.interfaces;

import com.example.pruebaTZ.dtos.SalesDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateSale {
    Mono<SalesDTO> apply(SalesDTO salesDTO);
}
