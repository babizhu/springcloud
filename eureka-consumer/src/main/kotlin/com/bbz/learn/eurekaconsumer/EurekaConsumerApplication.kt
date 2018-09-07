package com.bbz.learn.eurekaconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
//@EnableHystrix

class EurekaConsumerApplication

fun main(args: Array<String>) {
    runApplication<EurekaConsumerApplication>(*args)
}
