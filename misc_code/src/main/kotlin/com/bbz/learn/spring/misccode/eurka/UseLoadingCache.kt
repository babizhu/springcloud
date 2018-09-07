package com.bbz.learn.spring.misccode.eurka

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.google.common.cache.RemovalListener
import com.google.common.util.concurrent.ListenableFuture
import java.time.LocalTime
import java.util.concurrent.TimeUnit

/**
 * 学习eureka中的ResponseCacheImpl类中的成员变量readWriteCacheMap的类型Guava的LoadingCache。
 */
class UseLoadingCache {

    fun createCache(): LoadingCache<String, String> {

        return CacheBuilder.newBuilder().maximumSize(10)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .refreshAfterWrite(2, TimeUnit.MILLISECONDS)
                .removalListener(RemovalListener<String, String> { notification ->
                    println("${notification.key} is removed | ${notification.cause} ${LocalTime.now()}--${Thread.currentThread().name}") })
                .build(object : CacheLoader<String, String>() {
                    @Throws(Exception::class)
                    override fun load(key: String): String? {
                        val strProValue = "hello $key!"
                        println("$strProValue:${LocalTime.now()}  ${Thread.currentThread().name}")
                        return strProValue
                    }
                    override fun reload(key: String, oldValue: String): ListenableFuture<String> {
                        println("reload $key")
                        return super.reload(key, oldValue)
                    }
                })

    }
}

fun main(args: Array<String>) {
    val cache = UseLoadingCache().createCache()
    cache.get("jerry")
//    cache.refresh("jerry")
//    cache.get("panda")
    Thread.sleep(3000)
//    cache.get("jerry1")
    cache.get("jerry")

}