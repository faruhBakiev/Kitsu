package com.excample.kitsu.data.models.manga

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("posterImage")
    val posterImageManga: PosterImage,
    @SerializedName("titles")
    val titles: Titles
)