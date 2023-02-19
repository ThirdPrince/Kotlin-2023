package ch03

import ch01.delayExecutor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import kotlin.coroutines.*

/**
 * 代码3-2
 */
fun <R,T> launchCoroutine(receiver:R,block:suspend R.() -> T){
    block.startCoroutine(receiver,object :Continuation<T>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("Coroutine End:$result")
        }

    })
}

suspend fun delay(delay:Long) = suspendCoroutine<Unit> {
    delayExecutor.schedule({
        it.resume(Unit)
    },delay,TimeUnit.MILLISECONDS)
}
class ProducerScope<T>{
    suspend fun produce(value:T){
        println("produce $value")
    }
}

fun callLaunchCoroutine(){
    launchCoroutine(ProducerScope<Int>()){
        println("In Coroutine--${Thread.currentThread().name}")
        produce(1024)
        delay(3000)
        produce(2048)
        println("launch--${Thread.currentThread().name}")

    }
}

 fun main() {
    callLaunchCoroutine()
     println("main")
}

fun global(){
    GlobalScope.launch {
        delay(1000)
        println("launch--${Thread.currentThread().name}")
    }
}