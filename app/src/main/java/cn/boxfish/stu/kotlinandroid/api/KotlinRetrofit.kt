package cn.boxfish.stu.kotlinandroid.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

/**
 * Created by lishaowei on 2017/5/19.
 */
fun getPingInstance(): Retrofit {
    return Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("http://gank.io/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

}