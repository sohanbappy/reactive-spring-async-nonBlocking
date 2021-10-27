package com.reactivespring.controller;

import com.reactivespring.entity.MongoUser;
import com.reactivespring.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mongo")
public class MongoUserController {

    @Autowired
    MongoUserService service;

    @GetMapping(path = "/users")
    public Flux<MongoUser> getUsers() {
        return service.getUsers();
    }

    @GetMapping(path = "/userById/{id}")
    public Flux<MongoUser> getUser(@PathVariable int id) {
        return service.getUserByUserId(id);
    }

    @GetMapping("userByName/{name}")
    public Flux<MongoUser> getUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PostMapping(path = "/saveUser")
    public Mono<MongoUser> saveUser(@RequestBody Mono<MongoUser> user) {
        return service.saveUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public Mono<MongoUser> updateUser(@RequestBody Mono<MongoUser> user, @PathVariable String id) {
        return service.updateUser(user, id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id) {
        return service.deleteUser(id);
    }

}
