package com.excample.kitsu.data.models.anime

import com.google.gson.annotations.SerializedName

data class  AnimeItem(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)