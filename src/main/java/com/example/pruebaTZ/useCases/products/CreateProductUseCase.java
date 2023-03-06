package com.example.pruebaTZ.useCases.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.mapper.ProductsMapper;
import com.example.pruebaTZ.repositories.IProductRepository;
import com.example.pruebaTZ.useCases.products.interfaces.CreateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateProductUseCase implements CreateProduct {
    @Autowired
    private IProductRepository repository;

    @Autowired
    private ProductsMapper mapper;

    @Override
    public Mono<ProductsDTO> apply(ProductsDTO productsDTO){
        return repository
                .save(mapper
                        .dtoTOProducts()
                        .apply(productsDTO))
                .map(product -> mapper
                        .productsToDTO()
                        .apply(product));
    }
}
