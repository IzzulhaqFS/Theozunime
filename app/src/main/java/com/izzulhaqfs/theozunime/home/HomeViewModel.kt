package com.izzulhaqfs.theozunime.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.izzulhaqfs.theozunime.core.domain.usecase.AnimeUseCase

class HomeViewModel(animeUseCase: AnimeUseCase) : ViewModel() {
    var animes = animeUseCase.getAnimeRanking("all").asLiveData()
}