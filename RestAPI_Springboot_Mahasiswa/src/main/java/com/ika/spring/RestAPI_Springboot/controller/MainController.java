package com.ika.spring.RestAPI_Springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String home() {
        return "Belajar spring boot";
    }
}