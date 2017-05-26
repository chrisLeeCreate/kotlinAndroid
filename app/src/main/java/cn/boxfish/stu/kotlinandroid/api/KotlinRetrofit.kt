package cn.boxfish.stu.kotlinandroid.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

/**
 * Created by lishaowei on 2017/5/19.
 */
fun getInternetInstance(): Retrofit {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    return Retrofit.Builder()
            .client(client)
            .baseUrl("http://gank.io/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

}

fun getMusicInstance(): Retrofit {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val client = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    return Retrofit.Builder()
            .client(client)
            .baseUrl("http://s.music.163.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

}