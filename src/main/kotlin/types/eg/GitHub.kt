package types.eg

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 使用Retrofit 发起网络请求
 */
interface GitHubApi{
    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner")owner: String,@Path("repo")repo: String):Call<Repo>
}

fun main() {
    val gitHubApi = Retrofit.Builder().baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)
    val response = gitHubApi.getRepository("JetBrains","Kotlin").execute()
    val repo = response.body()
    if(repo == null){
        println("error!${response.code()}-${response.message()}")
    }else{
        println(repo.name)
        println(repo.owner.login)
        println((repo.stargazers_count))
        println(repo.forks_count)
        println(repo.html_url)
    }
}