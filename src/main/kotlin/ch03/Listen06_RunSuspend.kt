package ch03

import java.util.Objects
import kotlin.coroutines.*


internal fun runSuspend(block:suspend () -> Unit){
    val run = RunSuspend()
    block.startCoroutine(run)
    run.await()
}

private class RunSuspend:Continuation<Unit>{
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    var result:Result<Unit>? = null


    override fun resumeWith(result: Result<Unit>)  = synchronized(this){
        this.result = result
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")(this as Object).notifyAll()
    }


    fun await() = synchronized(this){
        while (true){
            when(val result = this.result){
                null -> @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") (this as Object).wait()
                else ->{
                    result.getOrNull()
                    return
                }
            }
        }
    }

}