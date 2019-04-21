package com.boco.app.provider.Yserver.entity.response;

import io.swagger.annotations.ApiModelProperty;

public class CommonResponse {
    @ApiModelProperty(value = "值")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
