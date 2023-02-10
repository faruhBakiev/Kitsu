package com.excample.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.excample.kitsu.base.BaseRepository
import com.excample.kitsu.data.remote.apiservices.MangaApiService
import com.excample.kitsu.data.remote.pagingsources.MangaPagingResource
import javax.inject.Inject

 class MangaRepository @Inject constructor(private val service: MangaApiService) : BaseRepository() {

    fun getManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingResource(service)
    }.liveData

    fun getSingleManga(id: Int) = doRequest {
        service.fetchSingleManga(id)
    }
}
