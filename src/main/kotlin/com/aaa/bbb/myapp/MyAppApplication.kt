package com.aaa.bbb.myapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyAppApplication

fun main(args: Array<String>) {
	runApplication<MyAppApplication>(*args)
}
