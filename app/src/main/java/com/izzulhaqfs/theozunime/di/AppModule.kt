package com.izzulhaqfs.theozunime.di

import com.izzulhaqfs.theozunime.core.domain.usecase.AnimeInteractor
import com.izzulhaqfs.theozunime.core.domain.usecase.AnimeUseCase
import com.izzulhaqfs.theozunime.detail.DetailAnimeViewModel
import com.izzulhaqfs.theozunime.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<AnimeUseCase> { AnimeInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailAnimeViewModel(get()) }
}