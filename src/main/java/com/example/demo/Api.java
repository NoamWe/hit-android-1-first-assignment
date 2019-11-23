package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @RequestMapping("echo")
    public String echo(@RequestParam(value = "name") String name){
        return "Hello " + name + "!";
    }
}
