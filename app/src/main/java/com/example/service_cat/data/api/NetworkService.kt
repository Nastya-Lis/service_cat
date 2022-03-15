package com.example.service_cat.data.api

import com.example.service_cat.utils.CustomConst
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {
        private const val BASE_URL = "https://thecatapi.com/api/v1/"

        private val loggingInterceptor = run{
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            }
        }

        private val baseInterceptor: Interceptor = Interceptor.invoke { chain ->
            val newUrl = chain
                .request()
                .url
                .newBuilder()
                .build()

            val request = chain
                .request()
                .newBuilder().addHeader("x-api-key", CustomConst.API_KEY)
                .url(newUrl)
                .build()

            return@invoke chain.proceed(request)
        }

        private val client: OkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(baseInterceptor)
            .build()

        fun retrofitService(): Api {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(Api::class.java)
                //.create(Api::class.java)
        }

}