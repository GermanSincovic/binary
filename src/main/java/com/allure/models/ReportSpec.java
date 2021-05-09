package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@Accessors(chain = true)
public class ReportSpec {

    @JsonProperty("path")
    private ArrayList<String> path;

    @JsonProperty("executorInfo")
    private ExecutorInfo executorInfo;
}
