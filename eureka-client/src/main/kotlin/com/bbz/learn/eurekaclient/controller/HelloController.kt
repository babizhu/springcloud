package com.bbz.learn.eurekaclient.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    @Value("\${server.port}")
      val port:Int?=null

    @Value("\${spring.application.name}")
//    @Value("\\$(server.port)")
    val applicationName:String?=null

    @RequestMapping("/info")
    fun hello(): String {
        return "hello xxx，this $port message"
    }

    /*
        服务提供者
     */
    @RequestMapping("/producerHello")
    fun hello(@RequestParam("name") name: String): String {
        return "hello $name，this $applicationName:$port message"
    }
}