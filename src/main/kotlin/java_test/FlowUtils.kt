package java_test

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.internal.ChannelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import suspend.runTaskSuspend
import utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.EmptyCoroutineContext


val channel = Channel<Int>(Int.MAX_VALUE)
suspend fun main() {
    message()
    val consume = GlobalScope.launch {
        while (true){
            val element = channel.receive()
            log(element)
            delay(1000)
            var runTaskSuspend = runTaskSuspend()
            log(runTaskSuspend)
            println(element)
            //println(element)
        }
    }
    consume.join()

}


fun generateNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000) // 模拟耗时操作
        emit(i)     // 发射数据项到Flow中
    }
}

 fun message() {

    var messageId = 0

    thread {
        GlobalScope.launch {
            while (true) {
                channel.send (messageId++)
                delay(10)
            }
        }
    }
}


interface DataCallback {
    fun onDataReceived(data: Int)
    fun onError(error: Throwable)
}

class Producer {
    private var callback: DataCallback? = null

    // 注册回调接口
    fun registerCallback(callback: DataCallback) {
        this.callback = callback
    }

    // 模拟在另一个线程不断生产数据，并通过回调接口通知数据
    fun startProducingData() {
        GlobalScope.launch {
            var data = 0
            while (true) {
                try {
                    delay(1000) // 模拟生产数据的耗时操作
                    callback?.onDataReceived(data)
                    data++
                } catch (e: Exception) {
                    callback?.onError(e)
                    break
                }
            }
        }
    }

    // 取消回调接口注册
    fun unregisterCallback() {
        callback = null
    }
}

// 将回调接口转换成Flow
fun DataCallback.asFlow(): Flow<Int> = channelFlow {
    // 注册回调接口
    val producer = Producer()
    producer.registerCallback(this@asFlow)


}






