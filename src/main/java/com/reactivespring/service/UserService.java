package com.reactivespring.service;

import com.reactivespring.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            User user = new User(i, "sohan" + i, "sohan" + i + "@email.com");
            userList.add(user);
            try {
                Thread.sleep(1000);//1 Sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}
