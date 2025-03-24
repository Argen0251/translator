package com.example.translator.data.service

import com.example.translator.data.models.TranslateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {
    @GET("translations")
    suspend fun translations(
        @Query("query") query: String,
        @Query("src") src: String,
        @Query("dst") dst: String,
        @Query("guess_direction") guess_direction: Boolean= false,
        @Query("follow_corrections") follow_corrections: String= "always",
        ):List<TranslateResponse>

}