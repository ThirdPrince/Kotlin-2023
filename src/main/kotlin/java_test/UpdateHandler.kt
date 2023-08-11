package java_test

import kotlinx.coroutines.runBlocking
import os.Handler
import os.Looper
import os.Message
import suspend.runTaskSuspend
import suspend.runTaskSuspendWithTimeOut
import utils.log

class UpdateHandler(looper: Looper):Handler(looper) {


    override fun handleMessage(msg: Message?) {
        super.handleMessage(msg)
        runBlocking {
            log(msg?.obj)
            var runTaskSuspend = runTaskSuspendWithTimeOut()
            log(runTaskSuspend)
        }

    }
}