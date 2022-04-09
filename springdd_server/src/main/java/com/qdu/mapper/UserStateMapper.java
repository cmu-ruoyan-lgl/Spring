package com.qdu.mapper;

import com.qdu.pojo.UserState;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserStateMapper {
    int addUserState(UserState userState);
}
