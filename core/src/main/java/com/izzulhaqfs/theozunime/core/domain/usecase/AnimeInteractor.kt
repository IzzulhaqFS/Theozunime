package com.izzulhaqfs.theozunime.core.domain.usecase

import com.izzulhaqfs.theozunime.core.data.Resource
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import com.izzulhaqfs.theozunime.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor(private val animeRepository: IAnimeRepository) : AnimeUseCase {
    override fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>> {
        return animeRepository.getAnimeRanking(rankingType)
    }

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return animeRepository.getFavoriteAnime()
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        animeRepository.setFavoriteAnime(anime, state)
    }
}