package com.allure.utils;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ResponseInfo {

    private final int responseCode;
    private String rawBody;
    private final Header[] headers;

    public ResponseInfo(HttpResponse response) {
        try {
            this.rawBody = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        this.responseCode = response.getStatusLine().getStatusCode();
        this.headers = response.getAllHeaders();
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getRawBody() {
        return rawBody;
    }

    public Header[] getHeaders() {
        return headers;
    }
}
