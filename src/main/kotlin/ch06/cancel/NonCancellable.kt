package ch06.cancel

import kotlinx.coroutines.*

suspend fun main() {
    GlobalScope.launch {
        val job = launch {
            listOf(1,2,3,4).forEach {
                yield()
                withContext(NonCancellable){
                    delay(it*100L)
                    println("----")
                }
            }
        }
        delay(200)
        job.cancelAndJoin()
    }.join()
}