package com.bbz.learn.eurekaconsumer.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping



@Service
@FeignClient(name= "demo-client")
interface HelloRemote {

    @RequestMapping(value = ["/producerHello"])
    fun sayHello(@RequestParam(value = "name") name: String): String
}