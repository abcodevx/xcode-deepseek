package com.xcodev.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 返回结果
 *
 * @author ixiao
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XCodevResult {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JsonCreator
    private XCodevResult(@JsonProperty("code") int code, @JsonProperty("data") Object data) {
        this.code = code;
        this.data = data;
    }

    private XCodevResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static XCodevResult ok() {
        return new XCodevResult(200, null);
    }

    public static XCodevResult ok(Object data) {
        return new XCodevResult(200, data);
    }

    public static XCodevResult error(String msg) {
        return new XCodevResult(500, "服务器内部错误:" + msg);
    }
}
