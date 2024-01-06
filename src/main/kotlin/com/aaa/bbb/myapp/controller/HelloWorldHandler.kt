package com.aaa.bbb.myapp.controller

import com.aaa.bbb.myapp.domain.ServiceA
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.system.measureTimeMillis

@RestController
@RequestMapping("/")
class HelloWorldHandler @Autowired constructor(private val serviceA: ServiceA) {

    @GetMapping("/{name}")
    suspend fun helloWorld(@PathVariable("name") name: String): String {
        val value = serviceA.getValue(name) ?: "I don't know"
        val total = measureTimeMillis {
            coroutineScope {
                val jobs = (0..1000).map { async { serviceA.suspendFun() } }
                jobs.forEach { it.await() }
            }
        }
        return "Hello, $value， $total ms"
    }
}

