package com.boco.app.provider.Xserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/getVersion")
    public String getVersion(){
        return "x server version";
    }
}
