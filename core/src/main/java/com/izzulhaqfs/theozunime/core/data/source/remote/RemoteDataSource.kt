package com.izzulhaqfs.theozunime.core.data.source.remote

import android.util.Log
import com.izzulhaqfs.theozunime.core.data.source.remote.network.ApiResponse
import com.izzulhaqfs.theozunime.core.data.source.remote.network.ApiService
import com.izzulhaqfs.theozunime.core.data.source.remote.response.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getAnimeRanking(rankingType: String): Flow<ApiResponse<List<DataItem>>> {
        return flow {
            try {
                val response = apiService.getAnimeRanking(CLIENT_ID, rankingType, QUERY_FIELDS, LIMIT)
                val dataArray = response.data
                if (dataArray.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response.data))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    companion object {
        private const val LIMIT = 100
        private const val CLIENT_ID = "53255cb0a67f23bec872f08df11d546f"
        private const val QUERY_FIELDS = "start_date,end_date,synopsis,mean,rank,popularity,num_list_users,num_scoring_users,genres,media_type,status,num_episodes,start_season,source,average_episode_duration,rating,studios"
    }
}