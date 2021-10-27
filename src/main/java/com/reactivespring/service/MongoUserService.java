package com.reactivespring.service;

import com.reactivespring.entity.MongoUser;
import com.reactivespring.repo.MongoUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MongoUserService {

    @Autowired
    MongoUserRepo userRepo;


    public Flux<MongoUser> getUsers() {
        return userRepo.findAll();
    }

    public Flux<MongoUser> getUserByUserId(int id) {
        return userRepo.findByUserId(id);
    }

    public Flux<MongoUser> getUserByName(String name) {
        return userRepo.findByName(name);
    }


    public Mono<MongoUser> saveUser(Mono<MongoUser> userMono) {
        return userMono
                .flatMap(userRepo::insert);
    }

    public Mono<MongoUser> updateUser(Mono<MongoUser> user, String id) {
        return userRepo.findById(id)
                .flatMap(u -> user
                        .doOnNext(e ->
                                {
                                    e.setId(id);
                                    e.setUserId(u.getUserId());
                                    e.setName(u.getName());
                                    e.setPhone(u.getPhone());
                                    e.setEmail(u.getEmail());
                                }
                        ))
                .flatMap(userRepo::save);

    }


    public Mono<Void> deleteUser(String id) {
        return userRepo.deleteById(id);
    }
}
