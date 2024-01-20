package com.example.applemusic.service

import com.example.applemusic.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ITunesApiService {
    @GET("rss/topsongs/limit=100/json")
    fun getTracks(): Call<ApiResponse>
}