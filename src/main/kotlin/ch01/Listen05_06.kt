package ch01

import common.api.httpClient
import okhttp3.Request
import other.SingleMethodCallback
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.WeakHashMap
import kotlin.concurrent.thread

/**
 * 代码1-5 1-6
 */

typealias Bitmap = ByteArray

fun main() {

    callAsync {
        println("End 0")
        callAsync {
            println("End 1")
        }
    }
    fun b(param: Int): String {
        return param.toString()
    }
    val d = ::b



}
val lam = { _:Bitmap -> Unit}

fun callAsync(callback: (Bitmap) -> Unit){
    val bitmap = asyncBitmap("https://www.bennyhuo.com/assets/avatar.jpg"){
        println("Async=$it")
        callback(it)
    }
    println("Main = $bitmap")
    if(bitmap != null){
        callback(bitmap)
    }

}

fun asyncBitmap(url: String, callback: (Bitmap) -> Unit): Bitmap? {
    return when (val bitmap = Cache.get(url)) {
        null -> {
            thread {
                download(url).also {
                    Cache.put(url, it)
                }.also(callback)
            }
            null
        }
        else -> bitmap
    }
}

/**
 * download url
 */
fun  download(url: String): Bitmap {
    return getAsStream(url).use {
        val bos = ByteArrayOutputStream()
        it.copyTo(bos)
        bos.toByteArray()
    }
}

/**
 * 从网络获取流
 */
fun getAsStream(url: String): InputStream = httpClient.newCall(Request.Builder().get().url(url).build())
    .execute().body()?.byteStream() ?: throw IOException("No body")


object Cache {
    private val map = WeakHashMap<String, Bitmap>()

    fun get(key: String): Bitmap? {
        return map[key]
    }

    fun put(key: String, bitmap: Bitmap) {
        map[key] = bitmap
    }
}