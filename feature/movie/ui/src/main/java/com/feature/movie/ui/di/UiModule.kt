package com.feature.movie.ui.di

import com.feature.movie.ui.navigation.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun provideMovieApi(): MovieApi {
        return MovieApi.BaseMovieAPiImpl()
    }
}