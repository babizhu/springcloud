package com.bbz.learn.eurekaclient.controller

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    @RequestMapping("/info")
    fun hello(): String {
        return "hello xxx，this is demo-client1 message"
    }

    /*
        服务提供者
     */
    @RequestMapping("/producerHello")
    fun hello(@RequestParam("name") name: String): String {
        return "hello $name，this is demo-client1 message"
    }
}