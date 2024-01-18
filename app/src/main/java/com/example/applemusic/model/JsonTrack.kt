package com.example.applemusic.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

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


data class Link(
    val attributes: LinkAttributes
)

data class LinkAttributes(
    val rel: String,
    val type: String,
    val href: String
)

data class Price(
    val label: String,
    //val attributes: Attributes
)

data class Rights(val label: String)

data class Id(
    val label: String,
    //val attributes: Attributes
)

data class Artist(
    val label: String,
    //val attributes: Attributes
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

fun parseJson(jsonString: String): List<Track> {
    val gson = Gson()
    val tracks: EntryListe = gson.fromJson(jsonString, object : TypeToken<EntryListe>() {}.type)

    return tracks.entry.map { track ->
        Track(
            name = track.name.label,
            imageUrl = track.images.lastOrNull()?.label.orEmpty(),
            artistName = track.artist.label,
            category = track.category.attributes.label
        )
    }
}

data class EntryListe(
    val entry : List<JsonTrack>
)
