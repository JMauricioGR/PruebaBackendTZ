package com.example.pruebaTZ.useCases.products.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteProduct {
    Mono<Void> apply(String id);
}
