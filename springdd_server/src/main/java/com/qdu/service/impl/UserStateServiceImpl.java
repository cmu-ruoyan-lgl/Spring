package com.qdu.service.impl;

import com.qdu.mapper.UserStateMapper;
import com.qdu.pojo.UserState;
import com.qdu.service.UserStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStateServiceImpl implements UserStateService {

    @Autowired
    private UserStateMapper userStateMapper;

    @Override
    public int addUserState(UserState userState) {
        return userStateMapper.addUserState(userState);
    }
}
