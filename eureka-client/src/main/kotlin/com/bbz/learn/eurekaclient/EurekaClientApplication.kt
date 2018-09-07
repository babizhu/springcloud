package com.bbz.learn.eurekaclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableEurekaClient

class EurekaClientApplication{
//    @Bean
//    fun kotlinPropertyConfigurer() = PropertySourcesPlaceholderConfigurer().apply {
//        setPlaceholderPrefix("%{")
//        setIgnoreUnresolvablePlaceholders(true)
//    }
//
//    @Bean
//    fun defaultPropertyConfigurer() = PropertySourcesPlaceholderConfigurer()
}

fun main(args: Array<String>) {
    runApplication<EurekaClientApplication>(*args)
}
