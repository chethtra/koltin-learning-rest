package com.cy.controller;

import com.cy.repo.UserRepo;
import com.cy.model.Users;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;


val UserMissingException = IllegalArgumentException("User is missing");

@RestController
@RequestMapping("/user")
class UserController{

    @Autowired
    lateinit var repo: UserRepo;

    @PostMapping("/")
    @ResponseBody
    fun createUser( @RequestBody @Valid newUser: Users) : Users{
        return repo.save(newUser);
    }

    @GetMapping("/{id}")
    @ResponseBody
    fun getUserById(@PathVariable id : Long): Users {
        return repo.findById(id)
        .orElseThrow({UserMissingException});
    }

    @GetMapping("/")
    @ResponseBody
    fun getUsers(): Iterable<Users>{
        return repo.findAll();
    }

    @PutMapping("/{id}")
    @ResponseBody
    fun updateUser(@PathVariable id: Long, @Valid @RequestBody updateBody: Users): Users{
        val (firstName, lastName, age, email) = updateBody; 
        return repo.findById(id).map({ 
            it.firstName = if(firstName.length == 0) it.firstName else firstName;
            it.lastName = if(lastName.length == 0) it.lastName else lastName;
            it.email = if(email.length == 0) it.email else email;
            it.age = if(age == -1) it.age else age;
            repo.save(it)
        })
        .orElseThrow({UserMissingException})
    }
}
