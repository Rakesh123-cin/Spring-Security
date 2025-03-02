package com.rakesh.SpringSecurityDemo.controller;

import com.rakesh.SpringSecurityDemo.model.User;
import com.rakesh.SpringSecurityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public User register(@RequestBody User user)
    {
        return userService.saveUser(user);
    }
}
