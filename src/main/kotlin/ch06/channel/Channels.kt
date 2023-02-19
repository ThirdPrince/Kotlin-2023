package ch06.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    basic()
}

suspend fun basic(){
    val channel = Channel<Int>()
    val producer = GlobalScope.launch {
        var i = 0
        while(true){
            channel.send(i++)
            println("send Thread = ${Thread.currentThread().name}}")
        }
    }

    val consume = GlobalScope.launch {
        while (true){
            val element = channel.receive()
            delay(1000)
            println(element)
            println("receive Thread = ${Thread.currentThread().name}}")
            //println(element)
        }
    }
    producer.join()
    consume.join()

}