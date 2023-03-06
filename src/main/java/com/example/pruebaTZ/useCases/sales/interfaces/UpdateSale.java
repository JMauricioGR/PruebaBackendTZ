package com.example.pruebaTZ.useCases.sales.interfaces;

import com.example.pruebaTZ.dtos.SalesDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateSale {
    Mono<SalesDTO> apply(String id, SalesDTO salesDTO);
}
