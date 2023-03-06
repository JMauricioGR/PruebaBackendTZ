package com.example.pruebaTZ.routes.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.useCases.products.UpdateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateProductRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProduct(UpdateProductUseCase useCase){
        return route(PUT("v1/api/products/{id}/update")
                .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductsDTO.class)
                        .flatMap(productDTO -> useCase.apply(request.pathVariable("id"), productDTO))
                        .flatMap(result -> result.getName()!= null? ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result): ServerResponse.status(HttpStatus.NOT_FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)));
    }
}
