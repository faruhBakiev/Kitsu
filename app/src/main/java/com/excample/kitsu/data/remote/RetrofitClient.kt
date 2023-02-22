package com.excample.kitsu.data.remote

import com.excample.kitsu.data.TokenInterceptor
import com.excample.kitsu.data.remote.apiservices.AnimeApiService
import com.excample.kitsu.data.remote.apiservices.MangaApiService
import com.excample.kitsu.data.remote.apiservices.SignInApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(TokenInterceptor())
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/edge/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)

    fun provideMangaApiService() = retrofitClient.create(MangaApiService::class.java)

    fun providerSignInApiService(): SignInApiService = retrofitClient.create(SignInApiService::class.java)
}