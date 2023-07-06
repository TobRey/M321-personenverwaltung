package com.example.personing.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class APIClient {

    companion object {

        private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val client : OkHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
        }.build()

        private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        private var retrofit = Retrofit.Builder()
            .baseUrl("https://iso.rohr.digital")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()

        fun getClient(): Retrofit {
            return retrofit
        }
    }

}