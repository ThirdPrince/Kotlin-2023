package advancedfunctions.sam

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * test1 和test 2区别
 *
 */
val executor: ExecutorService = Executors.newSingleThreadExecutor()
fun main() {
    test1()
    test2()


}

fun test1() {
    executor.submit {
        println("------")
    }
}

fun test2() {
    executor.submit {
        Runnable {
            println("------")
        }
    }
}