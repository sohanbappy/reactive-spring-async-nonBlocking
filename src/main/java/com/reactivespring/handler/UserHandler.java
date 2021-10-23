package com.reactivespring.handler;

import com.reactivespring.entity.User;
import com.reactivespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserHandler {

    @Autowired
    UserService userService;

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        Flux<User> allUserStreamRouter = userService.getAllUserStreamRouter();
        return ServerResponse.ok().body(allUserStreamRouter, User.class);
    }
}
