package java_test

import com.bennyhuo.kotlin.coroutines.dispatcher.CustomDispatchers
import com.bennyhuo.kotlin.coroutines.dispatcher.ui.AndroidDispatcher
import kotlinx.coroutines.*
import os.Handler
import os.Looper
import suspend.runTaskSuspend
import suspend.runTaskSuspendWithTimeOut
import suspend.runTaskSuspendWithTimeOut2
import utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object TaskTwo {

    @JvmStatic
    fun start() {
        GlobalScope.launch(CustomDispatchers.Default) {

            log("start ")

            val result = handlerSuspend()
            log(result)


            val deferred1 = async {
                runTaskSuspendWithTimeOut()
            }
            val deferred2 = async {
                runTaskSuspendWithTimeOut2()
            }
            val result1 = deferred1.await()
            val result2 = deferred2.await()
            log(result1.result)
            log(result2)


        }
    }

    private suspend fun handlerSuspend() =
        suspendCoroutine<String> {
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                it.resume("jjjjjj")
            },4000)
        }

}