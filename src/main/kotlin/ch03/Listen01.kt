package ch03

import kotlin.coroutines.*

fun main() {
    val continuation = suspend{
        println("In Coroutine")
        5
    }.createCoroutine(object :Continuation<Int>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("Coroutine ")
        }

    })
    continuation.resume(Unit)


}