package com.excample.kitsu.data.remote.apiservices

import com.excample.kitsu.data.models.anime.AnimeItem
import com.excample.kitsu.data.models.anime.AnimeResponse
import com.excample.kitsu.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse<AnimeItem>

    @GET("edge/anime/{id}")
    suspend fun fetchAnimeById(
        @Path("id") id: Int
    ): AnimeDetail
}