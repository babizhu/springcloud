package com.bbz.learn.spring.misccode.threads

import java.util.concurrent.Executors
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock

/**
 * 不采用低级的wait notify，而采用Condition来实现
 * n个线程交替执行 线程1-线程2-线程3-线程4-线程5-线程1-线程2-线程3-线程4-线程5-.....
 * 本程序通过调整THREAD_COUNT的数量，可以指定n个线程，从第一个线程依次往下执行
 */

const val THREAD_COUNT = 30

class Task(private val selfCondition: Condition, private val nextCondition: Condition, private val lock: ReentrantLock) : Runnable {

    private var count = 4
    override fun run() {

        lock.lock()
        try {
            while (count-- > 0) {
                selfCondition.await()
                println("${Thread.currentThread().name} is run, the count is $count")
//            Thread.sleep(500)
                nextCondition.signal()
            }
        } finally {
            lock.unlock()
        }
    }

}

class LockConditionStudy {

    private val lock = ReentrantLock()
    private val conditions = Array<Condition>(THREAD_COUNT) { lock.newCondition() }

    fun run() {
        val threadPool = Executors.newFixedThreadPool(THREAD_COUNT)
        repeat(THREAD_COUNT - 1) {
            threadPool.execute(Task(conditions[it], conditions[it + 1], lock))
        }
        threadPool.execute(Task(conditions[THREAD_COUNT - 1], conditions[0], lock))



        println("main thread running now")
        Thread.sleep(1000)
        lock.lock()
        conditions[0].signal()
        lock.unlock()
        threadPool.shutdown()
    }
}

fun main(args: Array<String>) {
    LockConditionStudy().run()
}
