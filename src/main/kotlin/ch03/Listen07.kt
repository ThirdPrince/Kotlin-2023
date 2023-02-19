package ch03

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.suspendCoroutine

/**
 * 代码 3-7
 */
suspend fun suspend01(a:Int){
    return
}

suspend fun suspend02(a:String,b:String) = suspendCoroutine<Int> {
    thread {
        it.resumeWith(Result.success(5))
       // println("Thread=  ${Thread.currentThread().name}")
    }
}

fun main() {
    GlobalScope.launch {
        val result = suspend02("4,","5")
        println("result = $result Thread = ${Thread.currentThread().name}")
    }
    Thread.sleep(5000)
}