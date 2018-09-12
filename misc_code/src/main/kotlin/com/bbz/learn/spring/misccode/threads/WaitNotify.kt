package com.bbz.learn.spring.misccode.threads

import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList

/**
 * wait notify使用
 * 创建两个线程，让这两个线程交替执行某个操作
 */
private const val COUNT = 10000

class WaitNotify {
    private val lock = java.lang.Object()

    fun run() {
        val list = ArrayList<String>()
        val executors = Executors.newFixedThreadPool(2)
        executors.execute(object : Runnable {
            val data = Array(COUNT) { i: Int -> "${i * 2}" }

            override fun run() {
                synchronized(lock) {
                    var currentIndex = 0

                    while (currentIndex < data.size) {
                        if (list.size % 2 == 0) {
                            list.add(data[currentIndex])
                            println("${Thread.currentThread().name} 插入${data[currentIndex]}完毕")
                            lock.notify()
                            currentIndex++
                        } else {
                            lock.wait()
                        }
                    }
                }
            }
        })
        executors.execute(object : Runnable {

            val data = Array(COUNT) { i: Int -> "${i * 2 + 1}" }
            override fun run() {
                synchronized(lock) {
                    var currentIndex = 0

                    while (currentIndex < data.size) {
                        if (list.size % 2 == 1) {
                            list.add(data[list.size / 2])
                            println("${Thread.currentThread().name} 插入${data[currentIndex]}完毕")
                            lock.notify()
                            currentIndex++
                        } else {
                            lock.wait()
                        }
                    }
                }
            }
        })

        executors.shutdown()
        executors.awaitTermination(5, TimeUnit.SECONDS)
        println(list)
//        list[98] = "34"
        for ((n, s) in list.withIndex()) {
            if (Integer.parseInt(s) != n) {
                println("$s 出错了")
                System.exit(0)
            }
        }
    }
}

fun main(args: Array<String>) {
    repeat(100) {
        WaitNotify().run()
    }
//    val data = ArrayList(listOf("1", "3", "5", "7", "9"))
//    var i = 0
//    while (temp != null) {
//        println(temp)
//    }
}
