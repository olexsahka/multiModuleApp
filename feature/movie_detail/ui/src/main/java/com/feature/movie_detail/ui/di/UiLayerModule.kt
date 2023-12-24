package com.feature.movie_detail.ui.di

import com.feature.movie_detail.ui.navigation.MovieDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object UiLayerModule {

    @Provides
    fun provideMovieDetailsApi() : MovieDetailApi{
        return MovieDetailApi.BaseMovieDetailApiImpl()
    }
}