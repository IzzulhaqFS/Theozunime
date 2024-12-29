package com.izzulhaqfs.theozunime.detail

import androidx.lifecycle.ViewModel
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import com.izzulhaqfs.theozunime.core.domain.usecase.AnimeUseCase

class DetailAnimeViewModel(private val animeUseCase: AnimeUseCase) : ViewModel() {
    fun setFavoriteAnime(anime: Anime, status: Boolean) {
        animeUseCase.setFavoriteAnime(anime, status)
    }
}