package common.api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface Api {

}

/**
 * Okhttp
 */
val httpClient by lazy {
    OkHttpClient.Builder().addInterceptor {
        it.proceed(it.request()).apply {
            println("request code = ${code()}")
        }
    }.build()
}

/**
 * Retrofit
 */
val  api by lazy {
    val retrofit = Retrofit.Builder().client(httpClient).baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    retrofit.create(Api::class.java)
}




