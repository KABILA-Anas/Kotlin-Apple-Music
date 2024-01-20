package com.example.applemusic.model

import com.google.gson.annotations.SerializedName

data class JsonTrack(
    @SerializedName("im:name") val name: Name,
    @SerializedName("im:image") val images: List<Image>,
    @SerializedName("im:artist") val artist: Artist,
    @SerializedName("category") val category: Category
)

data class Name(
    val label: String
)

data class Image(
    val label: String,
)

data class Artist(
    val label: String,
)

data class Category(
    val attributes: CategoryAttributes
)

data class CategoryAttributes(
    val id: String,
    val term: String,
    val scheme: String,
    val label: String
)