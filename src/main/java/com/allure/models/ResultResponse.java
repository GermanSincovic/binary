package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultResponse {

    @JsonProperty("uuid")
    private String uuid;

    @JsonProperty("size")
    private long size;

    @JsonProperty("created")
    private String created;

}
