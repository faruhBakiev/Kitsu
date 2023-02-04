package com.excample.kitsu.data.remote.apiservices

import com.excample.kitsu.data.models.AnimeResponse
import com.excample.kitsu.data.models.DataItem
import com.excample.kitsu.data.models.detail.AnimeDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiService {
    @GET("anime")
    suspend fun fetchAnime(): AnimeResponse<DataItem>

    @GET("anime/{id}")
    suspend fun fetchSingleAnime(@Path("id") id : Int): AnimeDetail

}