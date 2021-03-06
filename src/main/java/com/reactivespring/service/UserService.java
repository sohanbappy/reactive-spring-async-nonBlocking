package com.reactivespring.service;

import com.reactivespring.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static void sleepForSec(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .peek(UserService::sleepForSec)
                .mapToObj(i -> new User(i, "sohan" + i, "sohan" + i + "@email.com"))
                .forEachOrdered(user -> {
                    userList.add(user);
                });
        return userList;
    }

    public Flux<User> getAllUserStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new User(i, "sohan" + i, "sohan" + i + "@email.com"));
    }

    public Flux<User> getAllUserStreamRouter() {
        return Flux.range(1, 50)
                .map(i -> new User(i, "sohan" + i, "sohan" + i + "@email.com"));
    }
}
