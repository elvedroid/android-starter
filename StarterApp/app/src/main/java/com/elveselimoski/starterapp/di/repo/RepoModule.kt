package com.elveselimoski.starterapp.di.repo

import com.elveselimoski.starterapp.data.repo.service.RestService
import com.elveselimoski.starterapp.json.GsonUtil
import com.elveselimoski.starterapp.json.OkHttpClientUtil
import com.elveselimoski.starterapp.util.scheduler.DefaultSchedulerProvider
import com.elveselimoski.starterapp.util.scheduler.SchedulerProvider
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RepoModule(val baseUrl: String) {

    @Provides
    @Singleton
    internal fun provideRest(retrofit: Retrofit): RestService {
        return retrofit.create(RestService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClientUtil.defaultHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonUtil.defaultGson))
            .build()
    }

    @Provides
    @Singleton
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return DefaultSchedulerProvider()
    }
}
