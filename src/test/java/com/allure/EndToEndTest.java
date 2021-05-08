package com.allure;

import com.allure.models.ReportGenerateRequest;
import com.allure.service.AllureService;
import com.allure.utils.JsonUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EndToEndTest {

    private final AllureService allureService = new AllureService();

    @Test
    public void test1() {
//        System.out.println(Arrays.toString(allureService.getAllResults()));
//        System.out.println(allureService.postResultFile("src/test/resources/allureResults.zip"));

        String json = "{\n" +
                "  \"reportSpec\": {\n" +
                "    \"path\": [\n" +
                "      \"string\"\n" +
                "    ],\n" +
                "    \"executorInfo\": {\n" +
                "      \"name\": \"string\",\n" +
                "      \"type\": \"string\",\n" +
                "      \"url\": \"string\",\n" +
                "      \"buildOrder\": 0,\n" +
                "      \"buildName\": \"string\",\n" +
                "      \"buildUrl\": \"string\",\n" +
                "      \"reportName\": \"string\",\n" +
                "      \"reportUrl\": \"string\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"results\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"deleteResults\": true\n" +
                "}";

        ReportGenerateRequest rep = JsonUtils.toObject(json, ReportGenerateRequest.class);
        System.out.println(rep);
        System.out.println(JsonUtils.toJsonPretty(rep));

    }


}
