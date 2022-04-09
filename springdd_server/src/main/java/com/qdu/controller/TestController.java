package com.qdu.controller;

import com.qdu.pojo.User;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public User userRegister(){
        return userService.queryUserById(1);
    }
}
