package com.boco.app.provider.Yserver.controller;

import com.boco.app.provider.Yserver.entity.request.CommonRequest;
import com.boco.app.provider.Yserver.entity.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
@Api(value="app-version",description="公共控制器")
public class CommonController {

    @RequestMapping("/getVersion")
    @ApiOperation(value = "获取版本",notes = "注意，这是一个测试",httpMethod = "GET")
    public CommonResponse getVersion(CommonRequest request) {
        CommonResponse response = new CommonResponse();
        response.setValue(request.getRequestValue());
        return response;
    }
}
