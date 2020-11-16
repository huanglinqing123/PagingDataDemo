package com.example.paging3demo.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * @author huanglinqing
 * @project Paging3Demo
 * @date 2020/11/7
 * @desc 创建网络请求service的类
 */
object RetrofitService {


    /**
     * okhttp client
     */
    lateinit var okHttpClient: OkHttpClient

    /**
     * 主Url地址
     */
    private const val BASEAPI = "https://www.wanandroid.com/";


    /**
     * 创建service对象
     */
    fun <T> createService(mClass: Class<T>): T {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        val interceptor =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                //打印日志
                Log.d("黄临清",it)
            })

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient = builder.addInterceptor(interceptor).build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASEAPI)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(mClass) as T
    }

}