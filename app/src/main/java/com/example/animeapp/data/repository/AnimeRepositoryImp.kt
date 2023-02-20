package com.example.animeapp.data.repository

import com.example.animeapp.data.model.AnimeResponse
import com.example.animeapp.data.remote.AnimeApi
import retrofit2.Response
import javax.inject.Inject

class AnimeRepositoryImp @Inject constructor(
    val animeApi: AnimeApi
) : AnimeRepository {
    override suspend fun getRandomQuote(): Response<AnimeResponse> {
        return animeApi.getRandomQuote()
    }

    override suspend fun getQuoteByTitle(title: String): Response<AnimeResponse> {
        return animeApi.getQuoteByTitle(title)
    }


    override suspend fun getQuotesList(): Response<AnimeResponse> {
        return animeApi.getQuotesList()
    }
}