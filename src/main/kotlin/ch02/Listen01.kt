package ch02

import com.bennyhuo.kotlin.coroutines.dispatcher.CustomDispatchers
import kotlinx.coroutines.*
import os.Looper
import kotlin.coroutines.suspendCoroutine

suspend fun level_0() {
    withContext(Dispatchers.IO) {
        println("I am in level 0-->" + Thread.currentThread().name)
    }

    level_1()

}

suspend fun level_1() {
    withContext(Dispatchers.Default) {
        println("I am i leve 1!-->${Thread.currentThread().name}")
    }

    // suspendNow()
}

suspend fun suspendNow() = suspendCoroutine<Unit> {

}

fun main() {
    Looper.prepareMainLooper()
    GlobalScope.launch(CustomDispatchers.Android) {
        println("GlobalScope-->${Thread.currentThread().name}")
        level_0()
        println("launch finish-->${Thread.currentThread().name}\"")

    }
    println("main")
    Looper.loop()
}
