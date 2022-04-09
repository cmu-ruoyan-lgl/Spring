package com.qdu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserState implements Serializable {

    private int userId;
    private String userState;
    private Date userStateCreateTime;
    private Date userStateModifyTime;
}
