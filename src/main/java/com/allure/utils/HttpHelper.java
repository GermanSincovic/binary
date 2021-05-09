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
            Reporter.debug(String.format("REQUEST HEADERS [%s]", requestInfo.getHeaders().toString()));
        } else {
            Reporter.debug("REQUEST HEADERS []");
        }
        if (requestInfo.getRawBody() != null) {
            Reporter.debug(String.format("REQUEST BODY [%s]", requestInfo.getRawBody()));
        } else {
            Reporter.debug("REQUEST BODY []");
        }
    }

    private static void reportResponse(ResponseInfo responseInfo) {
        Reporter.debug(String.format("RESPONSE CODE [%s]", responseInfo.getResponseCode()));
        if (responseInfo.getHeaders() != null) {
            Reporter.debug(String.format("RESPONSE HEADERS [%s]", responseInfo.getHeaders().toString()));
        } else {
            Reporter.debug("RESPONSE HEADERS []");
        }
        if (responseInfo.getRawBody() != null) {
            Reporter.debug(String.format("RESPONSE BODY [%s]", responseInfo.getRawBody()));
        } else {
            Reporter.debug("RESPONSE BODY []");
        }
    }

}
