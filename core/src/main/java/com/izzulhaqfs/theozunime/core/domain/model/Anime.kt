package com.izzulhaqfs.theozunime.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val id: Int,
    val title: String,
    val mainPictureLarge: String?,
    val mainPictureMedium: String?,
    val startDate: String?,
    val synopsis: String?,
    val mean: Double?,
    val rank: Int?,
    val popularity: Int?,
    val numListUsers: Int?,
    val numScoringUsers: Int?,
    val genres: String?,
    val mediaType: String?,
    val status: String?,
    val numEpisodes: Int?,
    val startYear: Int?,
    val startSeason: String?,
    val source: String?,
    val averageEpisodeDuration: Int?,
    val rating: String?,
    val studios: String?,
    val isFavorite: Boolean
): Parcelable