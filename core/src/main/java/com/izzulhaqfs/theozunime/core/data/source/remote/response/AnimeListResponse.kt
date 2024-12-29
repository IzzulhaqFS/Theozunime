package com.izzulhaqfs.theozunime.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeListResponse(

    @field:SerializedName("data")
    val data: List<DataItem>,

    @field:SerializedName("paging")
    val paging: Paging
)