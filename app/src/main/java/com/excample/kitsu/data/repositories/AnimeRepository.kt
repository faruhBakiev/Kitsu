package com.excample.kitsu.data.repositories

import androidx.lifecycle.liveData
import com.excample.kitsu.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) {

    fun getAnime() = liveData{
      emit(service.fetchAnime())
    }

    fun getSingleAnime(id : Int) = liveData {
        emit(service.fetchSingleAnime(id))
    }

}