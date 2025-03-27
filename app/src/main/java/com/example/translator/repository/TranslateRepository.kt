package com.example.translator.repository

import com.example.translator.data.core.RetrofitClient
import com.example.translator.data.models.TranslateResponse
import com.example.translator.data.service.TranslateService
import javax.inject.Inject

class TranslateRepository @Inject
constructor(val apiService: TranslateService) {
    suspend fun translate(
        query: String,
        src: String,
        dst: String,
    ): List<TranslateResponse> {
        return apiService.translations(query, src, dst)
    }
}
