package com.example.pruebaTZ.routes.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.useCases.products.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import java.util.function.Function;

@Configuration
public class CreateProductRoute {
    @Bean
    public RouterFunction<ServerResponse> createProduct(CreateProductUseCase createProductUseCase){
        Function<ProductsDTO,Mono<ServerResponse>> executeCreate = productDTO -> createProductUseCase
                .apply(productDTO)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(POST("v1/api/products/create")
                .and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                .bodyToMono(ProductsDTO.class)
                .flatMap(executeCreate));
    }
}
