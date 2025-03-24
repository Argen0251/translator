package com.example.translator.repository

import com.example.translator.data.core.RetrofitClient
import com.example.translator.data.models.TranslateResponse

class TranslateRepository {
    private val apiService = RetrofitClient.translateService
    suspend fun translate(
        query: String,
        src: String,
        dst: String,
    ): List<TranslateResponse> {
        return apiService.translations(query, src, dst)
    }
}
