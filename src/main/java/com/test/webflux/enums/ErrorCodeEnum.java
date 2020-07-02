package com.test.webflux.enums;

import com.power.common.interfaces.IMessage;

/**
 * Error code enum
 * @author yu on 2018/09/29.
 */
public enum ErrorCodeEnum implements IMessage {

    SUCCESS("0000", "success"),

    PARAM_EMPTY("1001", "必选参数为空"),

    PARAM_ERROR("1002", "参数格式错误"),

    UNKNOWN_ERROR("9999", "系统繁忙，请稍后再试...."),

    NOT_FIND_RESULT("9001","未查询到相关数据");

    private String code;

    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public String toString() {
        return "[" + this.code + "]" + this.msg;
    }
}
