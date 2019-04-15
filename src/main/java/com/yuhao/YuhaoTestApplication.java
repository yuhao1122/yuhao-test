package com.yuhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class YuhaoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuhaoTestApplication.class, args);
    }

    /**
     * @description：测试
     * @author：Mr.Yu
     * @date：2019/3/29 15:03
     * @param：[]
     * @return：java.lang.String
     */
    @GetMapping("/")
    public String test() {
        return "你好，世界！";
    }
}
