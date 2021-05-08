package com.allure.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;

import java.io.File;
import java.util.Map;

public class RequestInfo {

    private String url;
    private RequestTypeEnum method;
    private Map<String, String> headers;
    private String rawBody;
    private File file;

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

    public File getFile() {
        return file;
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

    public RequestInfo(String url, RequestTypeEnum method, Map<String, String> headers, File file) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.file = file;
    }

}
