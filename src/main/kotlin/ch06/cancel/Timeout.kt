package ch06.cancel

import common.api.User
import common.api.githubApi
import kotlinx.coroutines.*

suspend fun main() {
    smartTimeout()
}

suspend fun dummyTimeout(){
    GlobalScope.launch {
        val userDeferred = async {
            getUserSuspend()
        }
        val timeoutJob = launch {
            delay(5000)
            userDeferred.cancel()
        }
        val user = userDeferred.await()
        timeoutJob.cancel()
        println(user)
    }.join()
}

suspend fun smartTimeout(){
    GlobalScope.launch{
        val user = withTimeout(1200){
            withContext(Dispatchers.IO){
                getUserSuspend()
            }

        }
        println(user)
    }.join()
    println("end..")
}

suspend fun getUserSuspend():User{
    return githubApi.getUserSuspend("bennyhuo")
}