package com.excample.kitsu.data.models.detail

import com.excample.kitsu.data.models.DataItem
import com.google.gson.annotations.SerializedName

data class AnimeDetail(
    @SerializedName("data")
    val data: DataItem
)