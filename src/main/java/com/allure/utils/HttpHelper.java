package com.allure.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;

public class HttpHelper {

    public static ResponseInfo makeCall(RequestInfo requestInfo) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        reportRequest(requestInfo);

        RequestBody body = null;

        if (requestInfo.getRawBody() != null) {
            MediaType mediaType = MediaType.parse("application/json");
            body = RequestBody.create(mediaType, requestInfo.getRawBody());
        }

        if (requestInfo.getFile() != null) {
            body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart(
                            "allureResults",
                            requestInfo.getFile().getName(),
                            RequestBody.create(MediaType.parse("application/zip"),
                                    requestInfo.getFile())
                    )
                    .build();
        }

        Request request = new Request.Builder()
                .url(requestInfo.getUrl())
                .method(requestInfo.getMethod().getMethod(), body)
                .build();
        ResponseInfo responseInfo = null;
        try {
            responseInfo = new ResponseInfo(client.newCall(request).execute());
            reportResponse(responseInfo);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return responseInfo;
    }

    private static void reportRequest(RequestInfo requestInfo) {
        Reporter.info(String.format("NEW [%s] REQUEST TO: %s", requestInfo.getMethod(), requestInfo.getUrl()));
        if (requestInfo.getHeaders() != null) {
            Reporter.info(String.format("REQUEST HEADERS [%s]", requestInfo.getHeaders().toString()));
        } else {
            Reporter.info("REQUEST HEADERS []");
        }
        if (requestInfo.getRawBody() != null) {
            Reporter.info(String.format("REQUEST BODY [%s]", requestInfo.getRawBody()));
        } else {
            Reporter.info("REQUEST BODY []");
        }
    }

    private static void reportResponse(ResponseInfo responseInfo) {
        Reporter.info(String.format("RESPONSE CODE [%s]", responseInfo.getResponseCode()));
        if (responseInfo.getHeaders() != null) {
            Reporter.info(String.format("RESPONSE HEADERS [%s]", responseInfo.getHeaders().toString()));
        } else {
            Reporter.info("RESPONSE HEADERS []");
        }
        if (responseInfo.getRawBody() != null) {
            Reporter.info(String.format("RESPONSE BODY [%s]", responseInfo.getRawBody()));
        } else {
            Reporter.info("RESPONSE BODY []");
        }
    }

}
