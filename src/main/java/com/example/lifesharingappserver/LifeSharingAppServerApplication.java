package com.example.lifesharingappserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class LifeSharingAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifeSharingAppServerApplication.class, args);
    }

    @GetMapping("/showOK")
    public static String showOk(){
        return "OK";
    }
}
