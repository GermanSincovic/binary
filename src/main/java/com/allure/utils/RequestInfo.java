package com.allure.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;

import java.util.Map;

public class RequestInfo {

    private String url;
    private RequestTypeEnum method;
    private Map<String, String> headers;
    private String rawBody;
    private HttpEntity httpEntity;

    public String getUrl() {
        return url;
    }

    public RequestTypeEnum getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getRawBody() {
        return rawBody;
    }

    public HttpEntity getHttpEntity() {
        return httpEntity;
    }

    public RequestInfo(String url, RequestTypeEnum method) {
        this.url = url;
        this.method = method;
    }

    public RequestInfo(String url, RequestTypeEnum method, Map<String, String> headers) {
        this.url = url;
        this.method = method;
        this.headers = headers;
    }

    public RequestInfo(String url, RequestTypeEnum method, Map<String, String> headers, String rawBody) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.rawBody = rawBody;
    }

    public RequestInfo(String url, RequestTypeEnum method, Map<String, String> headers, HttpEntity httpEntity) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.httpEntity = httpEntity;
    }

    public RequestInfo(String url, RequestTypeEnum method, Map<String, String> headers, String rawBody, HttpEntity httpEntity) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.rawBody = rawBody;
        this.httpEntity = httpEntity;
    }
}
