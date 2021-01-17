package com.sonbro.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeColtroller {
    @GetMapping("/")
    public String hello() {
        return "Hello World!!!!";
    }
}
