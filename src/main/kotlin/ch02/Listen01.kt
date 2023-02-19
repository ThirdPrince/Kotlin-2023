package ch02

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.suspendCoroutine

suspend fun level_0(){
    println("I am in level 0")
    level_1()

}

suspend fun level_1(){
    println("I am i leve 1!")
    suspendNow()
}
suspend fun suspendNow() = suspendCoroutine<Unit> {  }

fun main() {
    GlobalScope.launch {
        level_0()
    }
    Thread.sleep(300)
}
