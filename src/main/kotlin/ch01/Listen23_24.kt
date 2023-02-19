package ch01

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun bitmapSuspendable(url:String):Bitmap =
    suspendCoroutine {
        thread {
            try {
                it.resume(download(url))
            }catch (e:Exception){
                it.resumeWithException(e)
            }
        }
    }

fun main() {
    GlobalScope.launch {
        val bitmap = bitmapSuspendable("https://www.bennyhuo.com/assets/avatar.jpg")
        show(bitmap)
    }
    Thread.sleep(5000)

}

