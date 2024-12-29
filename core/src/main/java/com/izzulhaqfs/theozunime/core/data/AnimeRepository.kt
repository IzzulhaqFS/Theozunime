package com.izzulhaqfs.theozunime.core.data

import com.izzulhaqfs.theozunime.core.data.source.local.LocalDataSource
import com.izzulhaqfs.theozunime.core.data.source.remote.RemoteDataSource
import com.izzulhaqfs.theozunime.core.data.source.remote.network.ApiResponse
import com.izzulhaqfs.theozunime.core.data.source.remote.response.DataItem
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import com.izzulhaqfs.theozunime.core.domain.repository.IAnimeRepository
import com.izzulhaqfs.theozunime.core.utils.AppExecutors
import com.izzulhaqfs.theozunime.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AnimeRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAnimeRepository {
    override fun getAnimeRanking(rankingType: String): Flow<Resource<List<Anime>>> {
        return object : NetworkBoundResource<List<Anime>, List<DataItem>>() {
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAnimeRanking().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<DataItem>>> {
                return remoteDataSource.getAnimeRanking(rankingType)
            }

            override suspend fun saveCallResult(data: List<DataItem>) {
                val animeList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAnime(animeList)
            }

            override fun shouldFetch(data: List<Anime>?): Boolean = true
        }.asFlow()
    }

    override fun getFavoriteAnime(): Flow<List<Anime>> {
        return localDataSource.getFavoriteAnime().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntities(anime)
        appExecutors.diskIO().execute { localDataSource.setFavoriteAnime(animeEntity, state) }
    }
}