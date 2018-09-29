package com.reza.rezagithub.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.reza.rezagithub.TIMEOUT_REQUEST
import com.reza.rezagithub.api.GithubApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private  val baserUrl: String) {

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson) = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

    @Provides
    @Singleton
    fun provideRetrofitService(builder: Retrofit.Builder): GithubApiService = builder.baseUrl(baserUrl).build().create(GithubApiService::class.java)
}