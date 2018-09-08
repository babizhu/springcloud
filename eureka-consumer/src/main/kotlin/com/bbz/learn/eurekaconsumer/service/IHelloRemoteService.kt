package com.bbz.learn.eurekaconsumer.service

import feign.hystrix.FallbackFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping


@Service
@FeignClient(name = "demo-client", /*fallback = HelloRemoteServiceFallbackFactory::class*/fallbackFactory = HelloRemoteServiceFallbackFactory::class)
interface IHelloRemoteService {

    @RequestMapping(value = ["/producerHello"])
    fun sayHello(@RequestParam("name") name: String): String
}
//
@Component //配合@FeignClient的fallback属性
class HelloRemoteServiceHystric : IHelloRemoteService {
    override fun sayHello(name: String): String {
        return "sorry something wrong .Mr $name"
    }
}

@Component
class HelloRemoteServiceFallbackFactory : FallbackFactory<IHelloRemoteService> {
    override fun create(throwable: Throwable): IHelloRemoteService {
        return object : IHelloRemoteService {
            override fun sayHello(name: String): String {
                return "sorry something wrong .Mr $name ,because $throwable"
            }

        }

    }

}