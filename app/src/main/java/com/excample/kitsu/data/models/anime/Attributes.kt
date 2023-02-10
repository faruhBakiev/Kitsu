package com.excample.kitsu.data.models.anime

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("description")
    val description : String = " ",

    @SerializedName("posterImage")
    val posterImage: PosterImage,

    @SerializedName("titles")
    val titles: Titles,
)