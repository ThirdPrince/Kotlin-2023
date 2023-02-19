package ch03

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

fun main() {
    suspend{
        suspend02("Hello","Kotlin")
        println("====")
        suspend02("Hello","Coroutine")
    }.startCoroutine(object:Continuation<Int>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("resumeWith=${result}")
            result.getOrThrow()
        }

    })
//    GlobalScope.launch {
//        suspend02("Hello","Kotlin")
//        println("====")
//        suspend02("Hello","Coroutine")
//        println("====")
//    }
//    Thread.sleep(500)
}