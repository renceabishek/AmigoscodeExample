package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("user/v1")
public class UserController {

    private static List<User> USERS = Arrays.asList(
            new User("renceabishek", "Rence Abishek"),
            new User("charles", "Charles sargunam"),
            new User("sheeba", "Sheeba Baskar"),
            new User("keerthana", "Keerthi")
    );

    @GetMapping
    public List<User> getAllTheUsers() {
        return USERS;
    }

    @GetMapping(path = "/{userId}")
    public User getTheParticularUser(@PathVariable("userId") String userId) {
        return USERS.stream().filter(user -> user.getUserName().equals(userId))
                .findAny().orElseThrow(() -> new IllegalStateException("Unknown UserId"));
    }
}
