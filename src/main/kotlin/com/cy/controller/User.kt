package com.cy.controller;

import com.cy.repo.UserRepo;
import com.cy.model.Users;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/user")
class UserController{

    @Autowired
    lateinit var repo: UserRepo;

    @RequestMapping(method = [RequestMethod.POST])
    @ResponseBody
    fun createUser() : String{
        repo.save(Users("Bod", "Lee", 4, "mail@mail.com"));

        return "User saved";
    }

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    @ResponseBody
    fun getUserById(@PathVariable id : Long) = repo.findById(id);


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