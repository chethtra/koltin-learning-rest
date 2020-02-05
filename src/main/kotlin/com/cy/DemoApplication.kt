package com.cy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages=["com.cy.controller"])
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
