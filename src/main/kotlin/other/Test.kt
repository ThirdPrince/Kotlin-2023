package other

import ch03.launchCoroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main() {
//    GlobalScope.launch {
//        (1..100).forEach{
//            sunsTest(it)
//        }
//    }.join()
//    println("--------")
//    Thread.sleep(5000000)

    coroutineScope {
        println("coroutineScope Thread :${Thread.currentThread().name}")
        for (i in 0..5) {
            launch {
                sunsTest(i)
            }
        }
        // 你的程序应该在这里等待结果吧
        println("launch end")
    }
    println("end")

}


suspend fun sunsTest(int: Int) {
    println("start index =$int")
    println("sunsTest start Thread :${Thread.currentThread().name}")
    kotlinx.coroutines.delay(20)
    println("end index =$int")
    println("sunsTest end Thread :${Thread.currentThread().name}")
}