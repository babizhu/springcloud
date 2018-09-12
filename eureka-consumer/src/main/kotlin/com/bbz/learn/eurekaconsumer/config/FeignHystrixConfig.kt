package com.bbz.learn.eurekaconsumer.config

import com.bbz.learn.eurekaconsumer.service.IHelloRemoteService
import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey
import com.netflix.hystrix.HystrixCommandProperties
import feign.Feign
import feign.hystrix.HystrixFeign
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import feign.Retryer



/**
 * 指定feign中使用hystrix的相关配置
 */
@Configuration
class FeignHystrixConfig {
    /**
     * 重试次数
     */
    @Bean
    fun feignRetryer(): Retryer {
//        return Retryer.Default()
        return Retryer.Default(100, 1000, 4)
    }

    @Bean
    fun feignHystrixBuilder(): Feign.Builder {
        return HystrixFeign.builder().setterFactory { _, _ ->
            HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey(IHelloRemoteService::class.simpleName))// 控制 IHelloRemoteService 下,所有方法的Hystrix Configuration
                    .andCommandPropertiesDefaults(
                            HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000) // 超时配置
                    )

        }
    }
}