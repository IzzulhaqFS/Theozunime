package com.izzulhaqfs.theozunime.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DataItem(
    @field:SerializedName("node")
    val node: Node
)

data class Node(
    @field:SerializedName("end_date")
    val endDate: String? = null,

    @field:SerializedName("studios")
    val studios: List<StudiosItem>? = null,

    @field:SerializedName("rating")
    val rating: String? = null,

    @field:SerializedName("main_picture")
    val mainPicture: MainPicture? = null,

    @field:SerializedName("synopsis")
    val synopsis: String? = null,

    @field:SerializedName("source")
    val source: String? = null,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("start_season")
    val startSeason: StartSeason? = null,

    @field:SerializedName("average_episode_duration")
    val averageEpisodeDuration: Int? = null,

    @field:SerializedName("media_type")
    val mediaType: String? = null,

    @field:SerializedName("mean")
    val mean: Double? = null,

    @field:SerializedName("genres")
    val genres: List<GenresItem>? = null,

    @field:SerializedName("popularity")
    val popularity: Int? = null,

    @field:SerializedName("rank")
    val rank: Int? = null,

    @field:SerializedName("num_scoring_users")
    val numScoringUsers: Int? = null,

    @field:SerializedName("num_list_users")
    val numListUsers: Int? = null,

    @field:SerializedName("num_episodes")
    val numEpisodes: Int? = null,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("start_date")
    val startDate: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class GenresItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)

data class MainPicture(

    @field:SerializedName("large")
    val large: String? = null,

    @field:SerializedName("medium")
    val medium: String? = null
)

data class StudiosItem(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: Int
)

data class StartSeason(

    @field:SerializedName("year")
    val year: Int? = null,

    @field:SerializedName("season")
    val season: String? = null
)

data class Paging(

    @field:SerializedName("next")
    val next: String,

    @field:SerializedName("previous")
    val previous: String? = null,
)