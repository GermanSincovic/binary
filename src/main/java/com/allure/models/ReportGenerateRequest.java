package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ReportGenerateRequest {

    @JsonProperty("reportSpec")
    private ReportSpec reportSpec;

    @JsonProperty("results")
    private ArrayList<String> results;

    @JsonProperty("deleteResults")
    private Boolean deleteResults;

}
