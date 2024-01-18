package com.example.applemusic.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("feed") val feed: String
)
/*data class ApiResponse(
    @SerializedName("feed") val feed: Feed
)

data class Feed(
    @SerializedName("entry") val tracks: List<JsonTrack>
)*/