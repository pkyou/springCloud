package com.boco.app.provider.Yserver.entity.request;

import io.swagger.annotations.ApiModelProperty;

public class CommonRequest {
    @ApiModelProperty(value = "请求值",required = true)
    private String requestValue;

    public String getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }
}
