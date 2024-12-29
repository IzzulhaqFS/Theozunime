package com.izzulhaqfs.theozunime.core.utils

import com.izzulhaqfs.theozunime.core.data.source.local.entity.AnimeEntity
import com.izzulhaqfs.theozunime.core.data.source.remote.response.DataItem
import com.izzulhaqfs.theozunime.core.domain.model.Anime

object DataMapper {
    fun mapResponsesToEntities(input: List<DataItem>): List<AnimeEntity> {
        val animeList = ArrayList<AnimeEntity>()
        input.map {
            val anime = AnimeEntity(
                id = it.node.id,
                title = it.node.title,
                mainPictureLarge = it.node.mainPicture?.large,
                mainPictureMedium = it.node.mainPicture?.medium,
                startDate = it.node.startDate,
                synopsis = it.node.synopsis,
                mean = it.node.mean,
                rank = it.node.rank,
                popularity = it.node.popularity,
                numListUsers = it.node.numListUsers,
                numScoringUsers = it.node.numScoringUsers,
                genres = buildString {
                    if (!it.node.genres.isNullOrEmpty()) {
                        for (item in it.node.genres) {
                            append(item.name)
                            append(", ")
                        }
                    }
                },
                mediaType = it.node.mediaType,
                status = it.node.status,
                numEpisodes = it.node.numEpisodes,
                startYear = it.node.startSeason?.year,
                startSeason = it.node.startSeason?.season,
                source = it.node.source,
                averageEpisodeDuration = it.node.averageEpisodeDuration,
                rating = it.node.rating,
                studios = buildString {
                    if (!it.node.studios.isNullOrEmpty()) {
                        for (item in it.node.studios) {
                            append(item.name)
                            append(", ")
                        }
                    }
                }
            )
            animeList.add(anime)
        }
        return animeList
    }

    fun mapEntitiesToDomain(input: List<AnimeEntity>): List<Anime> {
        val animeList = ArrayList<Anime>()
        input.map {
            val anime = Anime(
                id = it.id,
                title = it.title,
                mainPictureLarge = it.mainPictureLarge,
                mainPictureMedium = it.mainPictureMedium,
                startDate = it.startDate,
                synopsis = it.synopsis,
                mean = it.mean,
                rank = it.rank,
                popularity = it.popularity,
                numListUsers = it.numListUsers,
                numScoringUsers = it.numScoringUsers,
                genres = it.genres,
                mediaType = it.mediaType,
                status = it.status,
                numEpisodes = it.numEpisodes,
                startYear = it.startYear,
                startSeason = it.startSeason,
                source = it.source,
                averageEpisodeDuration = it.averageEpisodeDuration,
                rating = it.rating,
                studios = it.studios,
                isFavorite = it.isFavorite
            )
            animeList.add(anime)
        }
        return animeList
    }

    fun mapDomainToEntities(input: Anime) = AnimeEntity(
        id = input.id,
        title = input.title,
        mainPictureLarge = input.mainPictureLarge,
        mainPictureMedium = input.mainPictureMedium,
        startDate = input.startDate,
        synopsis = input.synopsis,
        mean = input.mean,
        rank = input.rank,
        popularity = input.popularity,
        numListUsers = input.numListUsers,
        numScoringUsers = input.numScoringUsers,
        genres = input.genres,
        mediaType = input.mediaType,
        status = input.status,
        numEpisodes = input.numEpisodes,
        startYear = input.startYear,
        startSeason = input.startSeason,
        source = input.source,
        averageEpisodeDuration = input.averageEpisodeDuration,
        rating = input.rating,
        studios = input.studios
    )
}