package other

import ch04.js.async
import javafx.application.Application.launch
import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {

    GlobalScope.launch(dispatcher) {
        task1()

    }
    GlobalScope.launch(dispatcher) {
        task2()
    }





}
val threadPool: ExecutorService = Executors.newFixedThreadPool(4)
val dispatcher = threadPool.asCoroutineDispatcher()

suspend fun task1()   {
    while (true) {
        Thread.sleep(2000)
        println("task 1-->${Thread.currentThread().name}")
        task3()
    }
}

 fun task2()  {
    while (true) {
        Thread.sleep(2000)
        println("task 2-->${Thread.currentThread().name}")
    }
}
suspend fun task3() = withContext(Dispatchers.IO)  {
    while (true) {
        Thread.sleep(2000)
        println("task 3-->${Thread.currentThread().name}")
    }
}