package com.cy.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
@RestController
class GreetingController{
    @GetMapping("/greet")
    fun greeting(): String{
        return "Hello world";
    }
}