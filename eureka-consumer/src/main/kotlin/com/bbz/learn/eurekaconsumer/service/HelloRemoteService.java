//package com.bbz.learn.eurekaconsumer.service;
//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Service
//@FeignClient(value = "demo-client",fallback = HelloRemoteServiceHystric.class)
//public interface HelloRemoteService {
//    @RequestMapping(value = "/producerHello")
//     String sayHello(@RequestParam("name") String name);
//}
