package com.excample.kitsu.data.remote.apiservices

import com.excample.kitsu.data.models.detail.MangaDetail
import com.excample.kitsu.data.models.manga.MangaItem
import com.excample.kitsu.data.models.manga.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): MangaResponse<MangaItem>

    @GET("edge/manga/{id}")
    suspend fun fetchMangaById(
        @Path("id") id: Int
    ): MangaDetail
}