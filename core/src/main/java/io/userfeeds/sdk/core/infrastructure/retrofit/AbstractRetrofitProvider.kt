package io.userfeeds.sdk.core.infrastructure.retrofit

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.schedulers.Schedulers
import io.userfeeds.sdk.core.UserfeedsSdk
import io.userfeeds.sdk.core.infrastructure.Provider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object AbstractRetrofitProvider : Provider<Retrofit>({
    Retrofit.Builder()
            .baseUrl("https://api.userfeeds.io/beta/api/")
            .client(OkHttpClient.Builder()
                    .apply { if (UserfeedsSdk.debug) addInterceptor(HttpLoggingInterceptor().setLevel(BODY)) }
                    .addInterceptor {
                        val newRequest = it.request()
                                .newBuilder()
                                .addHeader("Authorization", UserfeedsSdk.apiKey)
                                .build()
                        it.proceed(newRequest)
                    }
                    .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
})
