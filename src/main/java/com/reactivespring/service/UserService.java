package com.reactivespring.service;

import com.reactivespring.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class UserService {

    private static void sleepForSec(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public List<User> getAllUser() throws InterruptedException {
        List<User> userList = new ArrayList<>();
        IntStream.rangeClosed(1, 50)
                .peek(UserService::sleepForSec)
                .mapToObj(i -> new User(i, "sohan" + i, "sohan" + i + "@email.com"))
                .forEachOrdered(user -> {
                    userList.add(user);
                });
        return userList;
    }
}
