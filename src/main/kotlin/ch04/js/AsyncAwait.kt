package ch04.js

import android.os.Handler
import android.os.Looper
import common.api.githubApi
import common.dispatcher.DispatchContext
import common.dispatcher.Dispatcher
import other.booleanTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.*

interface AsyncScope

suspend fun <T> AsyncScope.await(block:() -> Call<T>) = suspendCoroutine<T> {
    val call = block()
    call.enqueue(object:Callback<T>{
        override fun onResponse(call: Call<T>, response: Response<T>) {
            println("Thread =${Thread.currentThread().name}")
            println("response = ${response.body().toString()}")
            if(response.isSuccessful){
                response.body()?.let(it::resume)?:it.resumeWithException(NullPointerException())
            }else{
                it.resumeWithException(HttpException(response))
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            it.resumeWithException(t)
        }

    })

}

fun async(context: CoroutineContext= EmptyCoroutineContext,block: suspend AsyncScope.() -> Unit){

    val completion = AsyncCoroutine(context)
    block.startCoroutine(completion,completion)
}
class AsyncCoroutine(override val context: CoroutineContext = EmptyCoroutineContext):Continuation<Unit>,AsyncScope{
    override fun resumeWith(result: Result<Unit>) {
       result.getOrThrow()
    }

}

fun main() {
    Looper.prepareMainLooper()
    val handlerDispatch = DispatchContext(object :Dispatcher{
        val handler = Handler(Looper.getMainLooper())
        override fun dispatch(block: () -> Unit) {
            handler.post(block)
            //println("handler dispatch")
        }

    })
    githubApi.getUserCallback("bennyhuo")
    async(handlerDispatch) {
        val user = await {
            githubApi.getUserCallback("bennyhuo")
        }
        println("Thread = ${Thread.currentThread().name}")
        println(user)
    }

    Looper.loop()
}