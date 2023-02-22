package com.excample.kitsu.di

import android.content.Context
import com.excample.kitsu.data.preferences.PreferenceData
import com.excample.kitsu.data.preferences.PreferenceHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) =
        PreferenceHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferenceHelper) =
        PreferenceData(preferencesHelper)

}