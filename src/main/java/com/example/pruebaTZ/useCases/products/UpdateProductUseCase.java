package com.example.pruebaTZ.useCases.products;

import com.example.pruebaTZ.dtos.ProductsDTO;
import com.example.pruebaTZ.mapper.ProductsMapper;
import com.example.pruebaTZ.repositories.IProductRepository;
import com.example.pruebaTZ.useCases.products.interfaces.Updateproduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UpdateProductUseCase implements Updateproduct {

    private final IProductRepository repository;
    private final ProductsMapper mapper;

    @Override
    public Mono<ProductsDTO> apply(String id, ProductsDTO productsDTO){
        return repository.findById(id).flatMap(product -> {
           productsDTO.setId(product.getId());
           return repository
                   .save(mapper
                           .dtoTOProducts()
                           .apply(productsDTO))
                   .map(response -> mapper
                           .productsToDTO()
                           .apply(response));
        });
    }
}
