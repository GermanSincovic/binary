package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ReportResponse {

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("path")
    private String path;

    @JsonProperty("url")
    private String url;

    @JsonProperty("latest")
    private String latest;
}
