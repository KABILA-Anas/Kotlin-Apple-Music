package com.example.applemusic.service

import com.example.applemusic.model.ApiResponse
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET

interface ITunesApiService {
    @GET("rss/topsongs/limit=100/json")
    fun getTracks(): Call<ApiResponse>

    // create an instance of the ITunesApiService interface
    companion object Factory {
        fun create(): ITunesApiService {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("https://itunes.apple.com/")
                .build()

            return retrofit.create(ITunesApiService::class.java)
        }
    }
}