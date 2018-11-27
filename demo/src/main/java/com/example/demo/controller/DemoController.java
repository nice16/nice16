package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${foo}")
    private String foo;

    @RequestMapping(value="/demo")
    public String tt() {
        return foo;
    }
}