package com.example.animeapp.data.repository

import com.example.animeapp.data.model.AnimeResponse
import retrofit2.Response

interface AnimeRepository {
    suspend fun getRandomQuote(): Response<AnimeResponse>
    suspend fun getQuoteByTitle(title: String): Response<AnimeResponse>
    suspend fun getQuotesList(): Response<AnimeResponse>
}