package com.ss_2024_c2_e1.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo(){

        return "demo implementing 2 filters in this poc";
    }
}
