package ch03

import kotlin.coroutines.*

/**
 * 代码3-19
 * 拦截器使用
 */
class LogInterceptor :ContinuationInterceptor{
    override val key = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>) = LogContinuation(continuation)

}

class LogContinuation<T>(private val continuation:Continuation<T>):Continuation<T> by continuation{

    override fun resumeWith(result: Result<T>) {
        println("before resume:$result")
        continuation.resumeWith(result)
        println("after resume")
    }

}

fun main(){
    suspend {
        suspend02("hello","Kotlin")
    }.startCoroutine(object:Continuation<Int>{
        override val context: CoroutineContext
            get() = LogInterceptor()

        override fun resumeWith(result: Result<Int>) {
           result.getOrNull()
        }

    })
}