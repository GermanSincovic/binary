package com.allure;

import com.allure.models.ResultResponse;
import com.allure.utils.JsonUtils;
import org.testng.annotations.Test;

public class EndToEndTest {

    @Test
    public void getAllResultsTest() {
        String json = "{\"uuid\": \"asdfasdf\",\"size\":156,\"update_time\":\"2021-05-06T21:56:00Z\"}";
        ResultResponse resultResponse = JsonUtils.toObject(json, ResultResponse.class);

        System.out.println(JsonUtils.toJson(resultResponse));
        System.out.println(JsonUtils.toJsonPretty(resultResponse));
    }

}
