package advancedfunctions.sam

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 一个参数类型为只有一个方法的Java接口的方法调用时可用Lambda表达式作为参数
 */
fun main() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    executor.submit(object : Runnable {
        override fun run() {
            println("run in executor1")

        }
    })
    executor.submit {
        println("run in executor2")
    }

    executor.submit{ Runnable {
            println("run in runnable")
        }
    }.get()
    val future = executor.submit { Runnable {
            println("run in executor3")
        }
    }
    val result = future.get()
    println(result)
    executor.submit {
        println("run in executor4")
    }

    println("main thread")

    executor.submit(Runnable {
        println("run in executor6")
    })


}

fun Runnable(block:()->Unit):Runnable {
    return object :Runnable{
        override fun run() {
            block()
        }
    }
}