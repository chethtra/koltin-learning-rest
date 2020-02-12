package com.cy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
data class Users(
    @field:Size(min = 1)
    var firstName: String,
    var lastName: String,

    @field:Min(0)
    var age: Int,

    var email: String,

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long = -1
){
    private constructor(): this("", "", -1, "")
}