package com.bbz.learn.eurekaconsumer.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
//import com.bbz.learn.eurekaconsumer.service.HelloRemote
import com.bbz.learn.eurekaconsumer.service.IHelloRemoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController


@RestController
class ConsumerController {

    @Autowired
//    internal var helloRemote: HelloRemote? = null
    lateinit var helloRemoteService: IHelloRemoteService

    /*
        消费者的接口，去调用服务提供者
        问题：只能使用@RequestMapping("/consumerHello/{name}")  @PathVariable("name")方法 不知道有没有其它方式代替？
     */
    @RequestMapping("/consumerHello/{name}")
    fun index(@PathVariable("name") name: String): String {
        return helloRemoteService.sayHello(name)
    }

    //有问题的
    //    @RequestMapping("/consumerHello2")
    //    public String index2(@RequestParam("name") String name){
    //        return helloRemote.sayHello(name);
    //    }
    @RequestMapping("/info")
    fun info(): String {
        return " Hi,I am a consumer!"
    }
}