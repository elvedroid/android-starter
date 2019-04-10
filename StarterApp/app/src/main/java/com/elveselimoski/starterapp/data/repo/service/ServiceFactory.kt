package com.elveselimoski.starterapp.data.repo.service

import com.elveselimoski.starterapp.json.GsonUtil.defaultGson
import com.elveselimoski.starterapp.json.OkHttpClientUtil.defaultHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ServiceFactory {

    fun getRest(baseUrl: String): RestService {
        val retrofit = createRetrofit(baseUrl)
        return retrofit.create(RestService::class.java)
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .client(defaultHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(defaultGson))
            .build()
    }

}