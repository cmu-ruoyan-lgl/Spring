package com.qdu.enums;

public enum RegisterEnum {
    REGISTER_SUCCESS("注册成功"),
    REGISTER_USERNAME_EXIST("用户名已存在"),
    REGISTER_FAILURE("注册失败");

    private String name;
    RegisterEnum(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
