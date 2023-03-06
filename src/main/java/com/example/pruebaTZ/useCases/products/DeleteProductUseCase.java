package com.example.pruebaTZ.useCases.products;

import com.example.pruebaTZ.repositories.IProductRepository;
import com.example.pruebaTZ.useCases.products.interfaces.DeleteProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class DeleteProductUseCase implements DeleteProduct {

    private final IProductRepository repository;

    @Override
    public Mono<Void> apply(String id){
        return repository.deleteById(id);
    }
}
