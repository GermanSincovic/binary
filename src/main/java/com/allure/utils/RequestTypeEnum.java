package com.allure.utils;

public enum RequestTypeEnum {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    private final String method;

    public String getMethod() {
        return method;
    }

    RequestTypeEnum(String method) {
        this.method = method;
    }
}
