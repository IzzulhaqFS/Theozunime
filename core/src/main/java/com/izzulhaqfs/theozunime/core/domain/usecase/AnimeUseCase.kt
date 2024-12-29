package com.izzulhaqfs.theozunime.core.domain.usecase

import com.izzulhaqfs.theozunime.core.data.Resource
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {
    fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>>
    fun getFavoriteAnime(): Flow<List<Anime>>
    fun setFavoriteAnime(anime: Anime, state: Boolean)
}