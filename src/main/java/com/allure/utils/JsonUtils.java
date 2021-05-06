package com.allure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    public static <T> T toObject(String json, Class<T> clazz) {

        ObjectMapper objectMapper = new ObjectMapper();

        T obj = null;

        try {
            obj = objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    public static <T> String toJson(T obj, Boolean prettify) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            if (prettify) {
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            } else {
                json = objectMapper.writer().writeValueAsString(obj);
            }
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return json;
    }

    public static <T> String toJson(T obj) {
        return toJson(obj, false);
    }

    public static <T> String toJsonPretty(T obj) {
        return toJson(obj, true);
    }

}
