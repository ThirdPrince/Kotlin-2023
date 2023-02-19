package ch01

import kotlin.concurrent.thread

/**
 * 代码1-3
 * 异步callback
 */
fun main() {
    val callback:(String)-> Unit = {
        println(it)
    }

    val task = {
        while (true){
            Thread.sleep(500)
            println("C")
        }


        callback("F")
    }
    println("A")
    thread(block = task)
    println("B")
}