package com.jalilzod_art.firststep.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class HelloController {


    @RequestMapping("/hello")
    public String hello() {
        return "hello from Spring boot";
    }
    @RequestMapping("/about")
    public String about() {
        return "My name is Ming and im 26 y.o";
    }

}
