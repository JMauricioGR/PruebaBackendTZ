package com.example.pruebaTZ.useCases.products.interfaces;

import com.example.pruebaTZ.dtos.ProductsDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface Updateproduct {
    Mono<ProductsDTO> apply(String id, ProductsDTO productsDTO);
}
