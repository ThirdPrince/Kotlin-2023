package suspend

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import utils.log
import java.util.Timer
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * 异步回调转挂起函数
 */
 suspend fun main() {

    GlobalScope.launch {
        var runTaskSuspend = runTaskSuspend()
        log(runTaskSuspend)
    }.join()
}

/**
 * 单一方法接口
 */
interface SingleMethodCallback{
    fun onCallback(value:String)
}


fun runTask(callback:SingleMethodCallback){
    thread {
        Thread.sleep(3000)
        callback.onCallback("runTask result")
    }
}

suspend fun runTaskSuspend() = suspendCoroutine<String> { continuation ->
    runTask(object : SingleMethodCallback {
        override fun onCallback(value: String) {
            continuation.resumeWith(Result.success(value))
        }

    })

}

suspend fun runTaskSuspendWithTimeOut():Res = withTimeoutOrNull(4000) {
    suspendCoroutine<Res> { continuation ->
        runTask(object : SingleMethodCallback {
            override fun onCallback(value: String) {
                continuation.resume(Res(value))
            }

        })

    }
}?:Res("Time_Out")


suspend fun runTaskSuspendWithTimeOut2():String = withTimeoutOrNull(2000) {
    suspendCoroutine<String> { continuation ->
        runTask(object : SingleMethodCallback {
            override fun onCallback(value: String) {
                continuation.resumeWith(Result.success(value))
            }

        })

    }
}?:"Time_OUT"


class Res(val result:String)