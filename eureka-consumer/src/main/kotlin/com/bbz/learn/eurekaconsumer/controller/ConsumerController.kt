package com.bbz.learn.eurekaconsumer.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
//import com.bbz.learn.eurekaconsumer.service.HelloRemote
import com.bbz.learn.eurekaconsumer.service.IHelloRemoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class ConsumerController {

    @Autowired
//    internal var helloRemote: HelloRemote? = null
    lateinit var helloRemoteService: IHelloRemoteService

    /*
     *   消费者的接口，去调用服务提供者
     */
    @GetMapping("/consumerHello/{name}")
    fun consumerHello(@PathVariable("name") name: String): String {
        return helloRemoteService.sayHello(name)
    }

    @RequestMapping("/timeoutCall/{name}")
    fun timeoutCall(@PathVariable("name") name: String): String {
        return helloRemoteService.timeoutCall(name)
    }
    @RequestMapping("/info")
    fun info(): String {
        return " Hi,I am a consumer!"
    }
}