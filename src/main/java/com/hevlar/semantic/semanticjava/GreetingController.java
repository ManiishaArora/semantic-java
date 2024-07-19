package com.hevlar.semantic.semanticjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public String Greet(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }

    @GetMapping("/greet/v1")
    public String GreetOne(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }

    @GetMapping("/greet/v2")
    public String GreetTwo(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }

    @GetMapping("/greet/v3")
    public String GreetThree(@RequestParam(value = "name", defaultValue = "World") String name){
        return "Hello " + name;
    }
}
