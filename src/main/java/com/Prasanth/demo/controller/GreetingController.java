package com.Prasanth.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. Tells Spring this class handles web requests
@RestController 
public class GreetingController {

    // 2. Maps HTTP GET requests to the path "/" (root context)
    @GetMapping("/")
    public String sayHello() {
    	System.out.println("Hello server");
        return "hello prasanth v2";
    }
    
    @GetMapping("/hello")
    public String sayFuckOff() {
        return "fuckoff";
    }
}
