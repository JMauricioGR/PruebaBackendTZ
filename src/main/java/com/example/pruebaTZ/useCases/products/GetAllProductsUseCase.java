package com.example.pruebaTZ.useCases.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.mapper.ProductsMapper;
import com.example.pruebaTZ.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProductsUseCase {

    private IProductRepository repository;
    private ProductsMapper mapper;

    public Flux<ProductsDTO> getAllProducts(){
        return repository
                .findAll()
                .map(product -> mapper
                        .productsToDTO()
                        .apply(product));
    }
}
