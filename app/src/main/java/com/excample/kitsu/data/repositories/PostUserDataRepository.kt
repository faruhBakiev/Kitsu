package com.excample.kitsu.data.repositories

import com.excample.kitsu.base.BaseRepository
import com.excample.kitsu.data.models.auth.AuthModel
import com.excample.kitsu.data.remote.apiservices.SignInApiService
import javax.inject.Inject

class PostUserDataRepository @Inject constructor(
    private val api: SignInApiService
): BaseRepository() {
    fun postUserData(authModel: AuthModel) = doRequest {
        api.postAuthDataUser(authModel)
    }
}