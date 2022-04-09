package com.qdu.enums;

public enum UserStateEnum {
    NORMAL("正常"),
    ABNORMAL("封号"),
    CANCELLATION("注销");

    private String name;
    UserStateEnum(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
