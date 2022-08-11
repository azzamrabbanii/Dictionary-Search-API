package com.example.translateapp.network

import com.example.translateapp.data.TranslateItemResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{word}")
    fun getSearchItem(@Path("word") wordItem: String) : Call<List<TranslateItemResponseItem>>
}