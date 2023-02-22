package com.excample.kitsu.ui.fragments.signin

import com.excample.kitsu.base.BaseViewModel
import com.excample.kitsu.data.models.auth.AuthModel
import com.excample.kitsu.data.repositories.MangaRepository
import com.excample.kitsu.data.repositories.PostUserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repository: PostUserDataRepository ):BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}