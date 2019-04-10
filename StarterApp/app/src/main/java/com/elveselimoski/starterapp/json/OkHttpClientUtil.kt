package com.elveselimoski.starterapp.json

import androidx.annotation.NonNull
import com.elveselimoski.starterapp.StarterApp
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.util.concurrent.TimeUnit

object OkHttpClientUtil {
    private const val TIMEOUT_IN_SECONDS = 5L

    private val defaultHttpCliendBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
//        .addInterceptor(ExampleInterceptor())

    val defaultHttpClient: OkHttpClient = defaultHttpCliendBuilder.build()

    class ExampleInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            request = request.newBuilder()
//                .header("header-name", StarterApp.getInstance().getSomeHeader())
                .build()
            return chain.proceed(request)
        }

    }

}