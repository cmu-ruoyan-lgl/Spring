package com.qdu.controller;

import com.qdu.enums.RegisterEnum;
import com.qdu.pojo.User;
import com.qdu.service.UserService;
import com.qdu.service.UserStateService;
import com.qdu.utils.FillUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${user.userAvatar}")
    private String userAvatar;

    @Autowired
    private UserService userService;

    @Autowired
    private UserStateService userStateService;

    @PostMapping("/user/register")
    public String userRegister(@RequestBody User user) {
        User user1 = userService.queryUserByUserName(user.getUserName());
        if (user1 != null) {
            return RegisterEnum.REGISTER_USERNAME_EXIST.toString();
        }
        user.setUserAvatar(userAvatar);
        int result1 = userService.addUser(FillUtils.userFill(user));
        int result2 = userStateService.addUserState(FillUtils.userStateFill(user));
        return result1 + result2 > 1 ? RegisterEnum.REGISTER_SUCCESS.toString() : RegisterEnum.REGISTER_FAILURE.toString();
    }

}
