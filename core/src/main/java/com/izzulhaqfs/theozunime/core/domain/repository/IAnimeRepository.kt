package com.izzulhaqfs.theozunime.core.domain.repository

import com.izzulhaqfs.theozunime.core.data.Resource
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {
    fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>>
    fun getFavoriteAnime(): Flow<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}