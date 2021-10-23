package com.reactivespring.handler;

import com.reactivespring.entity.User;
import com.reactivespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(allUserStreamRouter, User.class);
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        Mono<User> user = userService.getAllUserStreamRouter().filter(u -> u.getId() == id).next();
        return ServerResponse.ok()
                .body(user, User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        Mono<String> response = user.map(u -> u.getId() + " : " + u.getName());
        return ServerResponse.ok()
                .body(response, String.class);
    }

}
