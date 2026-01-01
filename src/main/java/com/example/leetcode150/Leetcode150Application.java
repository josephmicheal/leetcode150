package com.example.leetcode150;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Leetcode150Application {
    public static void main(String[] args) {
        SpringApplication.run(Leetcode150Application.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from leetcode150 Test Application!";
    }
}
