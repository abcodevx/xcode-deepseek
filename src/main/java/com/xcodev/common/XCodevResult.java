package com.xcodev.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author ixiao
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XCodevResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    @JsonCreator
    private XCodevResult(@JsonProperty("code") int code, @JsonProperty("data") T data) {
        this.code = code;
        this.data = data;
    }

    private  XCodevResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> XCodevResult<T> ok() {
        return new XCodevResult<>(200, null);
    }

    public static <T> XCodevResult<T> ok(T data) {
        return new XCodevResult<>(200, data);
    }

    public static <T> XCodevResult<T> error(String msg) {
        return new XCodevResult<>(500, "服务器内部错误:" + msg);
    }
}
