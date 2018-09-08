package com.bbz.learn.spring.misccode.annotation

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * String也可以作为一个Bean被注入
 * 两个String的Bean如何区分
 * 如果两个类都有同名的String的Bean又如何区分
 */

@Configuration
class StringAnnotation {
    companion object {
//        private val logger = LogFactory.getLog(StringAnnotation.javaClass)
    }

    @Bean
    fun get(): String {
        return "StringAnnotation"
    }

    @Bean
    fun name(): String {
        return "StringAnnotation full name"
    }
}