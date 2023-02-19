package ch03


import jdk.nashorn.internal.objects.Global
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.xml.bind.JAXBElement.GlobalScope
import kotlin.coroutines.*

fun main() {
    val continuation = object :Continuation<String>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<String>) {
            println("结果：${result.getOrNull()} Thread----"+Thread.currentThread().name)
        }

    }
    block.startCoroutine(continuation)
    //block.createCoroutine(continuation)
    Thread.sleep(4000)


}
val block = suspend {
    println("start")
//    withContext(Dispatchers.IO){
//        println("end")
//        "DX3906"
//    }
    delay(2000)
    println("end")
    "DX3906"


}