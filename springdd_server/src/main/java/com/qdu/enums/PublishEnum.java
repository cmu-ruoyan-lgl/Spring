package com.qdu.enums;

public enum PublishEnum {
    PUBLISH_SUCCESS("发布成功");

    private String name;
    PublishEnum(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }
}
