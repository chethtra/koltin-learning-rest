package com.cy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
class Users(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val email: String,
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    val id: Long = -1
){
    private constructor(): this("", "", 0, "")
}