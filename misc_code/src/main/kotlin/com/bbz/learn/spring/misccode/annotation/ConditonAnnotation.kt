package com.bbz.learn.spring.misccode.annotation

import com.bbz.learn.spring.misccode.MisccodeApplication
import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.context.annotation.Bean
import java.awt.Point


/**
 * 学习条件注解，包括：
 * @ConditionalOnBean
 * @ConditionalOnClass
 * @ConditionalOnExpression
 * @ConditionalOnMissingBean
 */

@Configuration
class ConditonAnnotation {
    //如果存在MisccodeApplication类则创建Point类型的bean
    @ConditionalOnClass(value = [MisccodeApplication::class])
    @Bean
    fun point(): Point {
        return Point(3, 4)
    }

    /**
     * 系统中不存在名字为abcd的类，因此就不会存在此bean
     */
    @ConditionalOnClass(name = ["abcdab"])
    @Bean
    fun noPoint(): Point {
        return Point(30, 40)
    }
}