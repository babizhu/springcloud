package com.bbz.learn.spring.misccode.annotation

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class StringAnnotationTest {

//    下面的代码会报错，str不知道采用哪个字符串Bean
//    @Autowired
//    private lateinit var str: String


    @Autowired
    private lateinit var get: String

    @Autowired
    private lateinit var name: String

    /**
     * StringAnnotation，StringAnnotation1以及StringAnnotation2中都有名为get name的字符串Bean，运行代码看看最后打印出来什么
     * 我猜和类名的字典排序有关
     * 反正打印出来的是StringAnnotation2中的内容
     */
    @Test
    fun stringAnnotation() {
        System.err.println(get)
        System.err.println("name=$name")
    }
}