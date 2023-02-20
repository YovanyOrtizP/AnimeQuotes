package com.example.animeapp.data.model

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("anime")
    val anime: String? = "",
    @SerializedName("character")
    val character: String? = "",
    @SerializedName("quote")
    val quote: String? = ""
)
