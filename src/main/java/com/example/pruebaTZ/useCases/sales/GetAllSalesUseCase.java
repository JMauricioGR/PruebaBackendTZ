package com.example.pruebaTZ.useCases.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.mapper.SalesMapper;
import com.example.pruebaTZ.repositories.ISalesReository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllSalesUseCase {

    private final ISalesReository repository;
    private final SalesMapper mapper;

    public Flux<SalesDTO> getAllSales(){
        return repository
                .findAll()
                .map(sale -> mapper
                        .saleToDTO()
                        .apply(sale));
    }
}
