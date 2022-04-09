package com.qdu.enums;


public enum LoginEnum {
    LOGIN_SUCCESS("登陆成功"),
    LOGIN_FAILURE("用户名或密码错误"),
    LOGIN_USERNAME_NOT_EXIST("此用户未注册");

    private String name;
    LoginEnum(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
