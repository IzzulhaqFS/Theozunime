package com.izzulhaqfs.theozunime.core.data.source.remote.network

import com.izzulhaqfs.theozunime.core.data.source.remote.response.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("v2/anime/ranking")
    suspend fun getAnimeRanking(
        @Header("X-MAL-CLIENT-ID")
        clientId: String,

        @Query("ranking_type")
        rankingType: String,

        @Query("fields")
        fields: String,

        @Query("limit")
        limit: Int,
    ): AnimeListResponse
}