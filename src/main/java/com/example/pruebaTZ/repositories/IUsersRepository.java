package com.example.pruebaTZ.repositories;

import com.example.pruebaTZ.collections.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.Optional;

public interface IUsersRepository extends ReactiveMongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
