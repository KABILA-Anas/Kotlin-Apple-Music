package com.example.applemusic.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    val feed: Feed
)

data class Feed(
    @SerializedName("entry") val tracks: List<JsonTrack>
)