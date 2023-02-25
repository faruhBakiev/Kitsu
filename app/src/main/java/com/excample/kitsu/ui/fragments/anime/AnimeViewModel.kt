package com.excample.kitsu.ui.fragments.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.excample.kitsu.base.BaseViewModel
import com.excample.kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : BaseViewModel() {
    fun getAnime() = repository.getAnime().cachedIn(viewModelScope)
}