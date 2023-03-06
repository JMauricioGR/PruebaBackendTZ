package com.example.pruebaTZ.routes.products;

import com.example.pruebaTZ.useCases.products.DeleteProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {
    @Bean
    public RouterFunction<ServerResponse> deleteProduct(DeleteProductUseCase useCase){
        return route(DELETE("v1/api/product/{id}/delete")
                .and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInserters
                                .fromPublisher(useCase
                                        .apply(request
                                                .pathVariable("id")),
                                        Void.class)));
    }
}
