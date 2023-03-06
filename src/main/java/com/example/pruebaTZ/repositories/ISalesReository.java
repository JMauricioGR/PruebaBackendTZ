package com.example.pruebaTZ.repositories;

import com.example.pruebaTZ.collections.Sales;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesReository extends ReactiveMongoRepository<Sales, String> {
}
