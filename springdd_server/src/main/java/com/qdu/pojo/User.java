package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userAvatar;
    private String userRealName;
    private String userGender;
    private String userAddress;
    private String userQQId;
    private String userWeChatId;
    private Date userCreateTime;
    private Date userModifyTime;

    private UserState userState;

}
