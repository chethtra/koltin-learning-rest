package com.cy.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
class UserController{
    @RequestMapping(method = [RequestMethod.POST])
    @ResponseBody
    fun createUser() : String{
        return "User created";
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    @ResponseBody
    fun getUserById(@PathVariable id : Int) :String{
        return "Here is user ${id}"
    }


    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    @ResponseBody
    fun getUsers(): String{
        return "Here all the users";
    }

    @RequestMapping(value=["/{id}"], method = [RequestMethod.PATCH])
    @ResponseBody
    fun updateUser(@PathVariable id: Int): String{
        return "Updated user ${id}";
    }

}