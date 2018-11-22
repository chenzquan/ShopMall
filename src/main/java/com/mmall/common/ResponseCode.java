package com.mmall.common;

public enum  ResponseCode {

    SUCCESS(0,"SUCCESS"),//返回成功状态
    ERROR(1,"ERROR"),//返回错误状态
    NEED_LOGIN(10,"NEED_LOGIN"),//返回 需要登录状态
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");// 返回  非法参数状态

    private final String desc;
    private final int code;

    ResponseCode(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }
}
