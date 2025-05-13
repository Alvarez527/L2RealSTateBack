package com.l2realstate.inmobiliaria.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    // Add the controller.
    @RestController
    class HelloWorldController {
        @GetMapping("/hello")
        public String hello() {
            return "hello world!";
        }
    }

