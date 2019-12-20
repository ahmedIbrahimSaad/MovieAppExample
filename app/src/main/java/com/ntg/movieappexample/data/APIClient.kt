package com.ntg.movieappexample.data

import android.util.Log
import com.ntg.movieappexample.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {


    private val BASE_URL: String=""

    fun provideClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        okHttpClientBuilder.addInterceptor { chain ->
            val onging = chain.request().newBuilder()
            onging.addHeader("LangaugeID", "")
            onging.addHeader("Authorization", "")
            chain.proceed(onging.build())
        }

        return okHttpClientBuilder.build()
    }


    fun getRetrofit(): Retrofit {
        Log.d("Urlll", BASE_URL)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }



}