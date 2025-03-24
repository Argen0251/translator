package com.example.translator.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translator.data.models.TranslateResponse
import com.example.translator.repository.TranslateRepository
import kotlinx.coroutines.launch

class TranslateViewModel: ViewModel() {
    private val repository = TranslateRepository()
    val _translateResponse = MutableLiveData<List<TranslateResponse>>()
    val translateResponse: MutableLiveData<List<TranslateResponse>> = _translateResponse

    fun translate(query:String,src:String,dst:String){
        viewModelScope.launch {
            try {
                val response = repository.translate(query,src,dst)
                _translateResponse.postValue(response)
            }catch (e:Exception){
                Log.e("TranslateViewModel", "Error: ${e.message}", e)            }
        }
    }
}