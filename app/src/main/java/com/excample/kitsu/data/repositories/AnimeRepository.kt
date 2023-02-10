package com.excample.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.excample.kitsu.base.BaseRepository
import com.excample.kitsu.data.remote.apiservices.AnimeApiService
import com.excample.kitsu.data.remote.pagingsources.AnimePagingSource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun getAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSource(service)
    }.liveData

    fun getSingleAnime(id: Int) = doRequest {
        service.fetchSingleAnime(id)
    }
}
