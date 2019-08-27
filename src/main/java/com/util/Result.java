package com.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by moooke on 2019/8/27.
 */
public class Result<T> {

    private final static String successCode = "200";

    @ApiModelProperty(value = "code")
    private String code;

    @ApiModelProperty(value = "描述")
    private String message;

    @ApiModelProperty(value = "异常原因")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> cause;

    @ApiModelProperty(value = "返回结果值")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * Only used when 202 Created
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String location;

    public Result() {
    }

    public Result(String code, String message) {
        this(code, message, null);
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this(resultCode, null);
    }

    public Result(ResultCode resultCode, T data) {
        this(resultCode.getCode(), resultCode.getMessage(), data);
    }

    //成功 返回 不带 信息
    public static <T> Result<T> ofSucceed(T value) {
        return new Result<>(successCode, (String) null, value);
    }

    //成功返回 带 信息
    public static <T> Result<T> ofSucceed(String msg, T value) {
        return new Result<>(successCode, msg, value);
    }

    //失败 返回 带 错误码&信息
    public static <T> Result<T> ofFail(String code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> ofFail(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> Result<T> ofFail(ResultCode resultCode, T data) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    public boolean isSuccess() {
        return this.code.equals(successCode);
    }

    public void setResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public List<String> getCause() {
        return cause;
    }

    public void setCause(List<String> cause) {
        this.cause = cause;
    }

    public void setResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public void setResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
