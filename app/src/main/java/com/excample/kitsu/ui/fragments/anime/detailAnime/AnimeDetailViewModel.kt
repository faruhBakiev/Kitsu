package com.excample.kitsu.ui.fragments.anime.detailAnime

import androidx.lifecycle.ViewModel
import com.excample.kitsu.base.BaseViewModel
import com.excample.kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun getSingleAnime(id: Int) = repository.getSingleAnime(id)
}