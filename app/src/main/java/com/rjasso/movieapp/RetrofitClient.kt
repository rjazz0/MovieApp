package com.rjasso.movieapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{ chain ->
            val chainRequest = chain.request()
            val request = chainRequest.newBuilder().method(chainRequest.method(), chainRequest.body()).build()
            chain.proceed(request)
        }.build()
    val instance by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASEURL)
            .client(okHttpClient)
            .build()
        retrofit.create(MovieAPI::class.java)
    }

}