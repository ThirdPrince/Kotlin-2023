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
    test3()

}

fun test1() {
    executor.submit {
        println("------")
    }
}

/**
 * 相当于你submit了一个task，这个task new了一个runnable
 */
fun test2() {
    executor.submit {
      Runnable {
            println("------")
        }

    }
}

fun test3() {
    executor.submit {
        executor.submit(  Runnable {
            println("------")
        })

    }
}