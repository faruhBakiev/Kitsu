package com.excample.kitsu.data.models.detail

import com.excample.kitsu.data.models.manga.MangaItem
import com.google.gson.annotations.SerializedName

data class MangaDetail(
    @SerializedName("data")
    val data: MangaItem
)