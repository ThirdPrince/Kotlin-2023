package basic.delay



import kotlinx.coroutines.*
import utils.log

fun main() {
    runBlocking {
        // 第一个协程
        launch {
            log("协程1开始执行")
            log(delay(1000)) // 模拟耗时操作
            log("协程1执行结束")
        }

        // 第二个协程
        launch {
            log("协程2开始执行")
            log(delay(2000)) // 模拟耗时操作
            log("协程2执行结束")
        }

        // 第三个协程
        launch {
            log("协程3开始执行")
            log(delay(1500)) // 模拟耗时操作
            log("协程3执行结束")
        }

        GlobalScope.launch {
            log(delay(1500)) // 模拟耗时操
        }
    }
}