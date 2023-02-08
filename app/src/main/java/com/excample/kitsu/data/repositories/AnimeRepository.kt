package com.excample.kitsu.data.repositories

import androidx.lifecycle.liveData
import com.excample.kitsu.base.BaseRepository
import com.excample.kitsu.data.remote.apiservices.AnimeApiService
import com.excample.kitsu.utils.Resource
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun getAnime() = doRequest {
        service.fetchAnime()
    }

    fun getSingleAnime(id: Int) = doRequest {
        service.fetchSingleAnime(id)
    }
}

