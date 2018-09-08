package com.bbz.learn.spring.misccode.annotation

import com.bbz.learn.spring.misccode.MisccodeApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * 学习条件注解，包括：
 * @ConditionalOnBean
 * @ConditionalOnClass
 * @ConditionalOnExpression
 * @ConditionalOnMissingBean
 */

@Configuration
class ConditionAnnotation1 {
    companion object {
//        private val logger = LogFactory.getLog(ConditionAnnotation.javaClass)
    }


    //如果存在Application类则创建个值为hello的字符串类型的bean
    @ConditionalOnClass(value = [MisccodeApplication::class])
    @Bean
    fun get(): String {
        return "ConditionAnnotation1"
    }

    @ConditionalOnClass(name = ["com.bbz.learn.spring.misccode.MisccodeApplication"])
    @Bean
    fun name(): String {
        return "ConditionAnnotation1 full name"
    }
}