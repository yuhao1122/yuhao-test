package com.yuhao.controller;

import com.yuhao.aspect.anno.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：
 * @author：Mr.Yu
 * @date：2019/4/2 15:47
 * @version：V1.0
 */
@RestController
public class TestController {

    @SysLog("测试")
    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        return "余浩" + name;
    }

}
