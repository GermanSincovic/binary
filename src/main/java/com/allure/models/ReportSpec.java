package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ReportSpec {

    @JsonProperty("path")
    private ArrayList<String> path;

    @JsonProperty("executorInfo")
    private ExecutorInfo executorInfo;
}
