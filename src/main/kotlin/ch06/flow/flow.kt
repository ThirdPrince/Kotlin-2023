package ch06.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import other.delay
import java.util.concurrent.Executors

suspend fun main() {
    createFlow()
    flows()
}


fun sequences(){
    val ins = sequence{
        (1..3).forEach{
            yield(it)
        }
    }

    for (i in ins){
        println(i)
    }

    for (i in ins){
        println(i)
    }
}

fun createFlow() = flow<Int> {
    (1..3).forEach {
        emit(it)
        delay(100)
    }
}.onEach { println(it) }

suspend fun flows(){
    val intFlow = flow<Int> {
        (1..3).forEach {
            emit(it)
            delay(100)
        }
    }

    val dispatcher = Executors.newSingleThreadExecutor{
        Thread(it,"MyThread").also { it.isDaemon = true }
    }.asCoroutineDispatcher()
    GlobalScope.launch(dispatcher){
        intFlow.flowOn(Dispatchers.IO).collect {
            println(it)
        }
    }.join()
    intFlow.onEach {

    }.launchIn(GlobalScope)
}