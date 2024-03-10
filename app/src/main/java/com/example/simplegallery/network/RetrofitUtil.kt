//package com.example.simplegallery.network
//
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//
//private const val SERVER_URL = "https://picsum.photos/"
//
//private val retrofit: Retrofit by lazy {
//    val loggingInterceptor =
//        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//
//    val okHttpClient = OkHttpClient.Builder()
//        .readTimeout(5000, TimeUnit.MILLISECONDS)
//        .writeTimeout(5000, TimeUnit.MILLISECONDS)
//        .connectTimeout(5000, TimeUnit.MILLISECONDS)
//        .addInterceptor(loggingInterceptor)
//        .build()
//
//    Retrofit.Builder()
//        .baseUrl(SERVER_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(okHttpClient)
//        .build()
//}
//
//internal val photoApi: PhotoApi by lazy { retrofit.create(PhotoApi::class.java) }
//
