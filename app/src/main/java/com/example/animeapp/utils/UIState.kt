package com.example.animeapp.utils

import com.example.animeapp.data.model.AnimeResponse

sealed class UIState {
    object LOADING : UIState()
    data class SUCCESS(val response: AnimeResponse): UIState()
    class ERROR(val e: String) : UIState()
}