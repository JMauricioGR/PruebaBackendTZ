package com.example.pruebaTZ.useCases.sales;

import com.example.pruebaTZ.dtos.SalesDTO;
import com.example.pruebaTZ.mapper.SalesMapper;
import com.example.pruebaTZ.repositories.ISalesReository;
import com.example.pruebaTZ.useCases.sales.interfaces.CreateSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateSaleUseCase implements CreateSale {
    @Autowired
    private ISalesReository repository;

    @Autowired
    private SalesMapper mapper;

    @Override
    public Mono<SalesDTO> apply(SalesDTO salesDTO){
        return repository
                .save(mapper
                        .dtoToSale()
                        .apply(salesDTO))
                .map(sale -> mapper.saleToDTO().apply(sale));
    }
}
