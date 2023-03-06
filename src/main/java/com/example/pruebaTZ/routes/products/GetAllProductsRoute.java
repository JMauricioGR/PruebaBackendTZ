package com.example.pruebaTZ.routes.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.useCases.products.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {
    @Bean
    public RouterFunction<ServerResponse> allProducts(GetAllProductsUseCase getAllProductsUseCase){
        return route(GET("v1/api/products/all"),
                request -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(getAllProductsUseCase
                                        .getAllProducts(), ProductsDTO.class)));
    }
}
