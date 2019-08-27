package com.util;

import java.util.Objects;

/**
 * Created by moooke on 2019/8/27.
 */
public enum ResultCode {

    // Use standard HTTP status code
    OK("200", "OK"),
    BAD_REQUEST("400", "Bad Request"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "Forbidden"),
    NOT_FOUND("404", "Not Found"),
    CONFLICT("409", "Existed account"),
    NULL_PARAMETER("408", "null parameter"),
    INTERNAL_SERVER_ERROR("500", " Internal Server Error"),
    SYSTEM_ERROR("600", " system Error");

    private final String code;
    private final String message;

    private ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ResultCode codeOf(String code) {
        for (ResultCode value : values()) {
            if (Objects.equals(value.code, code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
