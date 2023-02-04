package com.excample.kitsu.ui.fragments.simpleAnime

import androidx.lifecycle.ViewModel
import com.excample.kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    fun getAnime() = repository.getAnime()
}