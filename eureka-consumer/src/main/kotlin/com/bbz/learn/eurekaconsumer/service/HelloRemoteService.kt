package com.bbz.learn.eurekaconsumer.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping



@Service
@FeignClient(name = "demo-client",fallback = HelloRemoteServiceHystric::class)
open interface HelloRemoteService {

    @RequestMapping(value = ["/producerHello"])
    fun sayHello(@RequestParam("name") name: String): String
}

@Component
class HelloRemoteServiceHystric : HelloRemoteService {
    override fun sayHello(name: String): String {
        return "sorry$name"
    }
}