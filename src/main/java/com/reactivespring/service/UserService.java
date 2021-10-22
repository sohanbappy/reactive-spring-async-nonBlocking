package com.reactivespring.service;

import com.reactivespring.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    private static List<User> userList;

    static {
        userList = Stream.of(new User(1, "sohan", "sohan@email.com"),
                new User(2, "bappy", "bappy@email.com"),
                new User(3, "sb", "sb@email.com"))
                .collect(Collectors.toList());
    }

    public List<User> getAllUser() {
        return userList;
    }
}
