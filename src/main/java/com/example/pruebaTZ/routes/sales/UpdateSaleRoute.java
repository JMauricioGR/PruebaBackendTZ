package com.example.pruebaTZ.routes.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.useCases.sales.UpdateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.REQUEST_ATTRIBUTE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateSaleRoute {
    @Bean
    public RouterFunction<ServerResponse> updateSale(UpdateSaleUseCase useCase){
        return route(PUT("v1/api/sales/{id}/update").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SalesDTO.class)
                        .flatMap(saleDTO -> useCase.apply(request.pathVariable("id"), saleDTO))
                        .flatMap(result -> result.getDate()!=null? ServerResponse
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result):
                                ServerResponse.status(HttpStatus.NOT_FOUND)
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)));
    }
}
