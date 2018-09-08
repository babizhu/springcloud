package com.bbz.learn.spring.misccode.annotation

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.awt.Point


@RunWith(SpringRunner::class)
@SpringBootTest
class ConditonAnnotationTest{
    @Autowired
    lateinit var point:Point

    @Autowired
    lateinit var qq: Point
    @Test
fun conditionPoint(){
        println(point)
        println(qq)
    }
}