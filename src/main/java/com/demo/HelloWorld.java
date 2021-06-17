package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @RequestMapping(value = "/home")
    String Home(){
        return "From Home Page...!! ";
    }
    @RequestMapping(value = "/about")
    String About(){
        return "Welcome SpringBoot...!! ";
    }
}
