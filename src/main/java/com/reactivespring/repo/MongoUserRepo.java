package com.reactivespring.repo;

import com.reactivespring.entity.MongoUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MongoUserRepo extends ReactiveMongoRepository<MongoUser, String> {

    Flux<MongoUser> findByName(String name);

    Flux<MongoUser> findByEmail(String email);

    Flux<MongoUser> findByUserId(int id);
}
