package com.example.pruebaTZ.repositories;

import com.example.pruebaTZ.collections.Products;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<Products, String> {
}
