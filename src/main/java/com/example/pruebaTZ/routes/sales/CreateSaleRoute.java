package com.example.pruebaTZ.routes.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.useCases.sales.CreateSaleUseCase;
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
public class CreateSaleRoute {
    @Bean
    public RouterFunction<ServerResponse> createSale(CreateSaleUseCase useCase){
        Function<SalesDTO, Mono<ServerResponse>> executeCreate = saleDTO -> useCase
                .apply(saleDTO)
                .flatMap(result -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return  route(POST("v1/api/sales/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SalesDTO.class)
                        .flatMap(executeCreate));
    }
}
