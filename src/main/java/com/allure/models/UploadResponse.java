package com.allure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UploadResponse {

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("uuid")
    private String uuid;

}
