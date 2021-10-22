package com.reactivespring.controller;

import com.reactivespring.entity.User;
import com.reactivespring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/allUser")
    public List<User> allUser() throws InterruptedException {
        return userService.getAllUser();
    }
}
