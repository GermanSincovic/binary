package com.allure.utils;

import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ResponseInfo {

    private final int responseCode;
    private String rawBody;
    private final Headers headers;

    public ResponseInfo(Response response) {
        try {
            this.rawBody = Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.responseCode = response.code();
        this.headers = response.headers();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getRawBody() {
        return rawBody;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        this.headers.forEach(pair -> headers.put(pair.component1(), pair.component2()));
        return headers;
    }
}
