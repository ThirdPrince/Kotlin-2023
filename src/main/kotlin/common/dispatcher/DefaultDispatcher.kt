package common.dispatcher

import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

/**
 * 默认Dispatch
 * 本质是个线程池
 */
object DefaultDispatcher :Dispatcher{

    private val threadGroup = ThreadGroup("DefaultDispatcher")

    private val threadIndex = AtomicInteger(0)

    /**
     * 线程池
     */
    private val executor = Executors.newFixedThreadPool(2*Runtime.getRuntime().availableProcessors()){
        Thread(threadGroup,it,"${threadGroup.name}-worker-${threadIndex.getAndIncrement()}")
    }

    override fun dispatch(block: () -> Unit) {
        executor.submit(block)
    }

}