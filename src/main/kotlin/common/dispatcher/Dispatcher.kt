package common.dispatcher

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 *
 */
interface Dispatcher {
    fun dispatch(block: () -> Unit)
}

open class DispatchContext(private val dispatcher: Dispatcher = DefaultDispatcher) :
    AbstractCoroutineContextElement(ContinuationInterceptor), ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> =
        DispatchedContinuation(continuation, dispatcher)


}

private class DispatchedContinuation<T>(
    val delegate: Continuation<T>, val dispatcher: Dispatcher,

    ) : Continuation<T> {
    override val context = delegate.context
    override fun resumeWith(result: Result<T>) {
        println("DispatchedContinuation resumeWith=${result.toString()}：Thread --${Thread.currentThread().name}")
        dispatcher.dispatch {
            delegate.resumeWith(result)
        }
    }

}