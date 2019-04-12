package com.elveselimoski.starterapp.di.repo;

import com.elveselimoski.starterapp.data.preferences.shared.SharedPrefs;
import com.elveselimoski.starterapp.data.preferences.shared.SharedPrefsImpl;
import com.elveselimoski.starterapp.data.repo.service.RestService;
import com.elveselimoski.starterapp.json.GsonUtil;
import com.elveselimoski.starterapp.json.OkHttpClientUtil;
import com.elveselimoski.starterapp.util.scheduler.DefaultSchedulerProvider;
import com.elveselimoski.starterapp.util.scheduler.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;

@Module
public class RepoModule {

    private final String baseUrl;

    public RepoModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    RestService provideRest(Retrofit retrofit) {
        return retrofit.create(RestService.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .client(OkHttpClientUtil.defaultHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(GsonUtil.defaultGson))
                .build();
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider(DefaultSchedulerProvider defaultSchedulerProvider) {
        return defaultSchedulerProvider;
    }

    @Provides
    @Singleton
    SharedPrefs provideSharedPrefs(SharedPrefsImpl sharedPrefs) {
        return sharedPrefs;
    }
}
