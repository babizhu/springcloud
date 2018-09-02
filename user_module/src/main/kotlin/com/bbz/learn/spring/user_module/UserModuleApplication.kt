package com.bbz.learn.spring.user_module

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableEurekaClient
class UserModuleApplication {

    @GetMapping("/")
    fun index(): String {
        return "hello UserModule"
    }
}

fun main(args: Array<String>) {
    runApplication<UserModuleApplication>(*args)
}
