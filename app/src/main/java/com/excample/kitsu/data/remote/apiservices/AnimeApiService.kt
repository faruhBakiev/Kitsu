package com.excample.kitsu.data.remote.apiservices

import com.excample.kitsu.data.models.anime.AnimeResponse
import com.excample.kitsu.data.models.anime.DataItem
import com.excample.kitsu.data.models.detail.AnimeDetail
import com.excample.kitsu.data.models.detail.MangaDetail
import com.excample.kitsu.data.models.manga.MangaItem
import com.excample.kitsu.data.models.manga.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

    @GET("anime/{id}")
    suspend fun fetchSingleAnime(@Path("id") id : Int): AnimeDetail


}