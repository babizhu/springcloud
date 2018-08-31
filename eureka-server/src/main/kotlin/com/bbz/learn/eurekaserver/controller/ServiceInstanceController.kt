package com.bbz.learn.eurekaserver.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.cloud.client.ServiceInstance
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.RestController


@RestController
class ServiceInstanceController {

    @Autowired
    private val discoveryClient: DiscoveryClient? = null

    @RequestMapping("/service-instances/{applicationName}")
    fun serviceInstancesByApplicationName(
            @PathVariable applicationName: String): List<ServiceInstance> {
        return this.discoveryClient!!.getInstances(applicationName)
    }

}

