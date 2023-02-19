package ch03

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * 代码3-8 不会挂起的挂起函数
 * 虽然下面有resume函数的调用，但协程不会真正挂起
 * 只有异步调用发生时才会真正挂起
 * 异步调用是否发生，取决于resume 韩顺 和对应的挂起函数的调用是否发生在相同的调用栈上，切换函数的调用栈的方法可以是切换到其他线程上执行
 * 也可以不切换线程但当前返回之后的某一个时刻在执行，比如Android 的Handler.post
 */
suspend fun notSuspend() = suspendCoroutine<Int> {
    it.resume(100)
}

fun main() {
    GlobalScope.launch {
        val value = notSuspend()
        println("value = $value Thread = ${Thread.currentThread().name}")
    }
    println("main")
    Thread.sleep(200)
}