package com.izzulhaqfs.theozunime.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzulhaqfs.theozunime.core.domain.usecase.AnimeUseCase

class FavoriteViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    val animes = animeUseCase.getFavoriteAnime().asLiveData()
}