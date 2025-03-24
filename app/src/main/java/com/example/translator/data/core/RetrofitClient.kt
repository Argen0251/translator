package com.example.translator.data.core

import com.example.translator.data.service.TranslateService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {

    private const val BASE_URL = "https://linguee-api.fly.dev/api/v2/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val Httpclient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    val retrofitService: Retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(Httpclient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
    }
    val translateService: TranslateService by lazy {
        retrofitService.create(TranslateService::class.java)
    }
}

