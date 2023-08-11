package coroutine.basic

import ch01.show
import common.api.User
import common.api.githubApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


fun async(){
    val call = githubApi.getUserCallback("ThirdPrince")
    call.enqueue(object : Callback<User>{
        override fun onResponse(call: Call<User>, response: Response<User>) {
            if (response.isSuccessful){
                response.body()?.let(::showUser)?: showError(NullPointerException())
            }else{
                println("error:"+response.code())
                println("error:${response.message()}")
            }


        }

        override fun onFailure(call: Call<User>, t: Throwable) {
           showError(t)
        }

    })
}


fun main(){
    async()

    //val user = User("a","b","c")
    //println(user.let(::showUser))
}