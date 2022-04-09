package com.qdu.service;


import com.qdu.pojo.User;

public interface UserService {
    User queryUserById(int userId);
    User queryUserByUserNameAndUserPassword(String userName, String userPassword);
    User queryUserByUserName(String userName);
    int addUser(User user);
    int updateUser(User user);
    int updateUserPwd(User user);
    int updateUserAvatar(User user);
    int deleteUser(int userId);
}
