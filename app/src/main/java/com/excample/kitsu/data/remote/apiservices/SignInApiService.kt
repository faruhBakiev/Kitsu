package com.excample.kitsu.data.remote.apiservices

import com.excample.kitsu.data.models.auth.AuthModel
import com.excample.kitsu.data.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}
