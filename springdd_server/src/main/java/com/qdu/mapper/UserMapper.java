package com.qdu.mapper;

import com.qdu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User queryUserById(int userId);
    User queryUserByUserNameAndUserPassword(String userName, String userPassword);
    User queryUserByUserName(String userName);
    int addUser(User user);
    int updateUser(User user);
    int updateUserPwd(User user);
    int updateUserAvatar(User user);
    int deleteUser(int userId);
}
