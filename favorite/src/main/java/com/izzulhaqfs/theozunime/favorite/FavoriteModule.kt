package com.izzulhaqfs.theozunime.favorite

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModul = module {
    viewModel { FavoriteViewModel(get()) }
}