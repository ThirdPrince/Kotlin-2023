package ch06.concurent

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import java.util.concurrent.atomic.AtomicInteger

suspend fun main() {

    counter()
    atomicCounter()
    mutexCounter()
    semaphoreCounter()
    pureFunctionCounter()

}

suspend fun counter(){
    var count = 0
    List(1000){
        GlobalScope.launch {
            count++
        }
    }.joinAll()
    println("count = $count")
}

suspend fun atomicCounter(){
    var count = AtomicInteger(0)
    List(1000){
        GlobalScope.launch {
            count.incrementAndGet()
        }
    }.joinAll()
    println("atomicCounter count = ${count.get()}")
}

suspend fun mutexCounter(){
    var count = 0
    val mutex = Mutex()
    List(1000){
        GlobalScope.launch {
            mutex.withLock {
                count++
            }
        }
    }.joinAll()
    println("mutexCounter = $count")
}

suspend fun semaphoreCounter(){
    var count = 0
    val semaphore = Semaphore(1)
    List(1000){
        GlobalScope.launch{
            semaphore.withPermit {
                count++
            }
        }
    }.joinAll()
    println("semaphoreCounter = $count")
}

suspend fun pureFunctionCounter(){
    val count = 0
    val result = count + List(1000){
        GlobalScope.async { 1 }
    }.map {
        it.await()
    }.sum()
    println("pureFunctionCounter = $result")
}