package ch01


import os.Handler
import os.Looper
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * 代码 1-4
 */
fun main() {
    loopMain {
        println("A-Thread:${Thread.currentThread().name}")
        delay(1000){
            println("B-Thread:${Thread.currentThread().name}")
            runOnMainThread {
                println("C-Thread:${Thread.currentThread().name}")
            }
        }

    }
}

fun loopMain(block: () -> Unit) {
    Looper.prepareMainLooper()
    runOnIoThread(block)
    Looper.loop()
}

val ioExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
val delayExecutor = Executors.newScheduledThreadPool(1)
val mainExecutor by lazy {
    Handler(Looper.getMainLooper())

}

fun runOnIoThread(block: () -> Unit){
    ioExecutor.execute(block)
}
fun runOnMainThread(block: () -> Unit){
    mainExecutor.post(block)

}
public fun delay(ms:Long,block: () -> Unit){
    delayExecutor.schedule(block,ms,TimeUnit.MILLISECONDS);
}
