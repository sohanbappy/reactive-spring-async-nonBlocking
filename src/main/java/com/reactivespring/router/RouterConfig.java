package com.reactivespring.router;

import com.reactivespring.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    UserHandler handler;


    @Bean
    public RouterFunction<ServerResponse> config() {
        return RouterFunctions.route()
                .GET("/router/userList", handler::getUsers)
                .build();
    }
}
