package com.example.animeapp.data.remote

import com.example.animeapp.data.model.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {
    //https://animechan.vercel.app/api/random (Get random Quote)
    //https://animechan.vercel.app/api/random/anime?title=naruto (Random Quote by anime title)
    //https://animechan.vercel.app/api/quotes (get 10 random quotes)

    @GET(RANDOM)
    suspend fun getRandomQuote(): Response<AnimeResponse>

    @GET(ENDPOINT)
    suspend fun getQuoteByTitle(
        @Query(PARAM_TITLE) anime: String
    ): Response<AnimeResponse>

    @GET(QUOTES)
    suspend fun getQuotesList(): Response<AnimeResponse>


    companion object{
        const val BASE_URL = "https://animechan.vercel.app"
        const val RANDOM = "/api/random"
        const val ENDPOINT = "/api/random/anime"
        const val PARAM_TITLE = "title"
        const val QUOTES = "/api/quotes"
    }
}