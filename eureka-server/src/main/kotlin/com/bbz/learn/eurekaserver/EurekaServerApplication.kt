package com.bbz.learn.eurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
@EnableEurekaServer
open class EurekaServerApplication {
    @GetMapping("/hello")
    fun index(): String {
        return "EurekaServer"
    }


}

fun main(args: Array<String>) {
    runApplication<EurekaServerApplication>(*args)
}
