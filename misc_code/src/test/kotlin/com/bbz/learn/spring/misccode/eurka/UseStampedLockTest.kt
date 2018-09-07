package com.bbz.learn.spring.misccode.eurka

import org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

class UseStampedLockTest {
    @Test
    fun moveTest() {
        val point = UseStampedLock.Point()
        val countDownLatch = CountDownLatch(10)
        val threadPool = Executors.newCachedThreadPool()
        repeat(100) {
            threadPool.execute {
                repeat(10) {
                    point.move(0.1, 0.1)
                    println("${Thread.currentThread().name}: point.x:${point.x},point.y:${point.x}")
                }
                countDownLatch.countDown()

            }
        }
        countDownLatch.await()
        println("lk:${Thread.currentThread().name}: point.x:${point.x},point.y:${point.x}")

    }
}