package other

import ch01.runOnMainThread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * suspendCoroutine
 * https://zhuanlan.zhihu.com/p/569412300
 */
interface SingleMethodCallback {
    fun onCallBack(value: String)
}

fun runTask(callback: SingleMethodCallback) {
    thread {
        Thread.sleep(1000)
        callback.onCallBack("result")
    }
}

fun runTaskDefault() {
    runTask(object : SingleMethodCallback {
        override fun onCallBack(value: String) {
            println("value = $value")
        }

    })
}

suspend fun runTaskWithSuspend(): String {
    return suspendCoroutine {
        runTask(object : SingleMethodCallback {
            override fun onCallBack(value: String) {
                it.resume(value)
            }

        })
    }
}

fun main() {


    test4()
}

/**
 * https://zhuanlan.zhihu.com/p/451902378
 */
fun test(){
    GlobalScope.launch {
        println("Before--${Thread.currentThread().name}")
        suspendCoroutine<Unit> {
            println("Before too")
            thread {
                Thread.sleep(300)
                it.resumeWith(Result.success(Unit))
            }

        }
        println("After--${Thread.currentThread().name}")
    }
    Thread.sleep(400)
}

fun  test2(){
    GlobalScope.launch {
        println("Before--${Thread.currentThread().name}")
        suspendCoroutine<Unit> {
            invokeAfterSecond {
                it.resume(Unit)
            }
        }
        println("After--${Thread.currentThread().name}")
    }

    Thread.sleep(2000)
}

fun test3(){
    GlobalScope.launch {
        println("before")
        delay(1000)
        println("after")
    }
    Thread.sleep(2000)
}

fun test4(){
    GlobalScope.launch {
       val result =  strTest()
        println("result = $result")
    }
    Thread.sleep(2000)
}

fun invokeAfterSecond(block:()-> Unit){
    thread {
        Thread.sleep(1000)
        block.invoke()
    }
}
private val executor = Executors.newSingleThreadScheduledExecutor{
    Thread(it,"scheduler").apply {
        isDaemon = true
    }
}

suspend fun delay(time:Long):Unit = suspendCoroutine {
    executor.schedule({it.resume(Unit)},time,TimeUnit.MILLISECONDS)
}

suspend fun intTest(){
     suspendCoroutine<Int> {
        it.resume(42)
    }
}

suspend fun strTest():String{
    val result = suspendCoroutine<String> {
        it.resume("some text")
    }
    return result
}

suspend fun booleanTest(){
    suspendCoroutine<Boolean> {
        it.resume(true)
    }
}


