package com.qdu.service.impl;


import com.qdu.mapper.UserMapper;
import com.qdu.pojo.User;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(int userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public User queryUserByUserNameAndUserPassword(String userName, String userPassword) {
        return userMapper.queryUserByUserNameAndUserPassword(userName,userPassword);
    }

    @Override
    public User queryUserByUserName(String userName) {
        return userMapper.queryUserByUserName(userName);
    }

    @Override
    public int addUser(User user) {
        int rows1 = userMapper.addUser(user);
        return rows1;
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int updateUserPwd(User user) {
        return userMapper.updateUserPwd(user);
    }

    @Override
    public int updateUserAvatar(User user) {
        return userMapper.updateUserAvatar(user);
    }

}
