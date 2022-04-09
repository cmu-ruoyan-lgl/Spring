package com.qdu.controller;

import com.qdu.enums.LoginEnum;
import com.qdu.pojo.User;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String login(@RequestBody User user){
        User user1 = userService.queryUserByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
        User user2 = userService.queryUserByUserName(user.getUserName());
        if(user1 != null){
            return LoginEnum.LOGIN_SUCCESS.toString();
        }else if(user2 == null){
            return LoginEnum.LOGIN_USERNAME_NOT_EXIST.toString();
        }else{
            return LoginEnum.LOGIN_FAILURE.toString();
        }
    }
}
