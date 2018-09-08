package com.bbz.learn.spring.misccode

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.beans.factory.annotation.Autowired



@RunWith(SpringRunner::class)
@SpringBootTest
class MisccodeApplicationTests {
    @Autowired
    private lateinit var get: String

    @Autowired
    private lateinit var name: String

    @Test
    fun contextLoads() {

        System.err.println(get)
        System.err.println("name=$name")
    }

}
