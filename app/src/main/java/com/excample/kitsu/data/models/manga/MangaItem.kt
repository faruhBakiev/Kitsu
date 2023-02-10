package com.excample.kitsu.data.models.manga

import com.google.gson.annotations.SerializedName

data class MangaItem(
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)