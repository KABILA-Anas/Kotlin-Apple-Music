package com.example.applemusic.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applemusic.model.ApiResponse
import com.example.applemusic.service.ITunesApiService
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val apiService : ITunesApiService) : ViewModel() {

    val topTracks : MutableLiveData<ApiResponse> = MutableLiveData()

    fun getTopTracks() {

        apiService.getTracks().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    topTracks.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                topTracks.postValue(null)
            }
        })

    }

}