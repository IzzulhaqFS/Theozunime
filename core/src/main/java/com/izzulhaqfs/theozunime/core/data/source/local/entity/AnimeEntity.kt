package com.izzulhaqfs.theozunime.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class AnimeEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "main_picture_large")
    val mainPictureLarge: String? = null,

    @ColumnInfo(name = "main_picture_medium")
    val mainPictureMedium: String? = null,

    @ColumnInfo(name = "start_date")
    val startDate: String? = null,

    @ColumnInfo(name = "synopsis")
    val synopsis: String? = null,

    @ColumnInfo(name = "mean")
    val mean: Double? = null,

    @ColumnInfo(name = "rank")
    val rank: Int? = null,

    @ColumnInfo(name = "popularity")
    val popularity: Int? = null,

    @ColumnInfo(name = "num_list_users")
    val numListUsers: Int? = null,

    @ColumnInfo(name = "num_scoring_users")
    val numScoringUsers: Int? = null,

    @ColumnInfo(name = "genres")
    val genres: String? = null,

    @ColumnInfo(name = "media_type")
    val mediaType: String? = null,

    @ColumnInfo(name = "status")
    val status: String? = null,

    @ColumnInfo(name = "num_episodes")
    val numEpisodes: Int? = null,

    @ColumnInfo(name = "start_year")
    val startYear: Int? = null,

    @ColumnInfo(name = "start_season")
    val startSeason: String? = null,

    @ColumnInfo(name = "source")
    val source: String? = null,

    @ColumnInfo(name = "average_episode_duration")
    val averageEpisodeDuration: Int? = null,

    @ColumnInfo(name = "rating")
    val rating: String? = null,

    @ColumnInfo(name = "studios")
    val studios: String? = null,

    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)
