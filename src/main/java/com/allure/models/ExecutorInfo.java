package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ExecutorInfo {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private String url;

    @JsonProperty("buildOrder")
    private Integer buildOrder;

    @JsonProperty("buildName")
    private String buildName;

    @JsonProperty("buildUrl")
    private String buildUrl;

    @JsonProperty("reportName")
    private String reportName;

    @JsonProperty("reportUrl")
    private String reportUrl;
}
