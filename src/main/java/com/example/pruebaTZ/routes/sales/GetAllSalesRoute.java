package com.example.pruebaTZ.routes.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.useCases.sales.GetAllSalesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllSalesRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllSales(GetAllSalesUseCase useCase){
        return route(GET("v1/api/sales/all"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(useCase
                                        .getAllSales(),
                                        SalesDTO.class)));
    }
}
