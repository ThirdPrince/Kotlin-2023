package ch01

import kotlin.concurrent.thread

/**
 * 代码1-2
 * 异步
 */
fun main() {
    val task = {
        println("C")
    }
    println("A")
    thread (block = task )
    println("B")
}