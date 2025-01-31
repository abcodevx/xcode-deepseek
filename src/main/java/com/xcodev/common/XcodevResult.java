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
public class XcodevResult<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    @JsonCreator
    private XcodevResult(@JsonProperty("code") int code, @JsonProperty("data") T data) {
        this.code = code;
        this.data = data;
    }

    private XcodevResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> XcodevResult<T> ok() {
        return new XcodevResult<>(200, null);
    }

    public static <T> XcodevResult<T> ok(T data) {
        return new XcodevResult<>(200, data);
    }

    public static <T> XcodevResult<T> error(String msg) {
        return new XcodevResult<>(500, "服务器内部错误:" + msg);
    }
}
