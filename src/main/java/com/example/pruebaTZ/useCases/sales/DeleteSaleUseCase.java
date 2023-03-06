package com.example.pruebaTZ.useCases.sales;

import com.example.pruebaTZ.repositories.ISalesReository;
import com.example.pruebaTZ.useCases.sales.interfaces.DeleteSale;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteSaleUseCase implements DeleteSale {

    private final ISalesReository repository;

    @Override
    public Mono<Void> apply(String id) {
        return repository.deleteById(id);
    }
}
