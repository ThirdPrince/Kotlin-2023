package java_test

import com.bennyhuo.kotlin.coroutines.dispatcher.CustomDispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import suspend.runTaskSuspend
import utils.log

object TaskOne {

    @JvmStatic
    fun start(){
        GlobalScope.launch(CustomDispatchers.Android) {
            var runTaskSuspend = runTaskSuspend()
            log(runTaskSuspend)
            delay(1000)
            var runTaskSuspend2 = runTaskSuspend()
            log(runTaskSuspend2)
        }
    }
}