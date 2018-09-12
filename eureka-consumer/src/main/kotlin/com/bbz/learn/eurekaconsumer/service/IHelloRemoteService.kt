package com.bbz.learn.eurekaconsumer.service

import feign.hystrix.FallbackFactory
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping


@Service
@FeignClient(name = "demo-client", /*fallback = HelloRemoteServiceFallbackFactory::class*/fallbackFactory = HelloRemoteServiceFallbackFactory::class)
interface IHelloRemoteService {

    @GetMapping(value = ["/producerHello"])
    fun sayHello(@RequestParam("name") name: String): String

    @RequestMapping(value = ["/timeoutCall"])
    fun timeoutCall(@RequestParam("name") name: String): String

}


@Component
class HelloRemoteServiceFallbackFactory : FallbackFactory<IHelloRemoteService> {
    override fun create(throwable: Throwable): IHelloRemoteService {
        return object : IHelloRemoteService {
            override fun timeoutCall(name: String): String {
                return "sorry something wrong .Mr $name ,because $throwable"
            }

            override fun sayHello(name: String): String {
                return "sorry something wrong .Mr $name ,because $throwable"
            }

        }

    }


//@Component //配合@FeignClient的fallback属性
//class HelloRemoteServiceHystric : IHelloRemoteService {
//    override fun timeoutCall(name: String): String {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun sayHello(name: String): String {
//        return "sorry something wrong .Mr $name"
//    }
//}
}