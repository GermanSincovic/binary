package com.allure.utils;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpHelper {

    public static ResponseInfo makeCall(RequestInfo requestInfo) {

        HttpClient client = HttpClientBuilder.create().build();

        if (requestInfo.getMethod() == RequestTypeEnum.GET) {

            HttpGet requester = new HttpGet(requestInfo.getUrl());
            if (requestInfo.getHeaders() != null) {
                requestInfo.getHeaders().forEach(requester::setHeader);
            }
            try {
                return new ResponseInfo(client.execute(requester));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else if (requestInfo.getMethod() == RequestTypeEnum.POST){

            HttpPost requester = new HttpPost(requestInfo.getUrl());
            if (requestInfo.getHeaders() != null) {
                requestInfo.getHeaders().forEach(requester::setHeader);
            }
            if (requestInfo.getRawBody() != null) {
                try {
                    requester.setEntity(new StringEntity(requestInfo.getRawBody()));
                } catch (UnsupportedEncodingException e){
                    System.out.println(e.getMessage());
                }
            }
            try {
                return new ResponseInfo(client.execute(requester));
            } catch (IOException e){
                System.out.println(e.getMessage());
            }

        } else if(requestInfo.getMethod() == RequestTypeEnum.PUT){
            HttpPut requester = new HttpPut(requestInfo.getUrl());
            if (requestInfo.getHeaders() != null) {
                requestInfo.getHeaders().forEach(requester::setHeader);
            }
            if (requestInfo.getRawBody() != null) {
                try {
                    requester.setEntity(new StringEntity(requestInfo.getRawBody()));
                } catch (UnsupportedEncodingException e){
                    System.out.println(e.getMessage());
                }
            }
            try {
                return new ResponseInfo(client.execute(requester));
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } else if(requestInfo.getMethod() == RequestTypeEnum.DELETE){
            HttpDelete requester = new HttpDelete(requestInfo.getUrl());
            if (requestInfo.getHeaders() != null) {
                requestInfo.getHeaders().forEach(requester::setHeader);
            }
            try {
                return new ResponseInfo(client.execute(requester));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return null;

    }

}
