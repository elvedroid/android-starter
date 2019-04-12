package com.elveselimoski.starterapp.json;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class OkHttpClientUtil {

    private static final long TIMEOUT_IN_SECONDS = 5L;
    private static OkHttpClient.Builder defaultHttpCliendBuilder = new OkHttpClient.Builder()
            .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
    public static OkHttpClient defaultHttpClient = defaultHttpCliendBuilder.build();
//        .addInterceptor(new ExampleInterceptor());

    private OkHttpClientUtil() {
    }

    class ExampleInterceptor implements Interceptor {
        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request();
            request = request.newBuilder()
//                    .addHeader("header-name", StarterApp.getInstance().getSomeHeader())
                    .build();
            return chain.proceed(request);
        }
    }

}