package com.example.multimoduleapp.di

import com.example.multimoduleapp.navigation.NavigationProvider
import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_detail.ui.navigation.MovieDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(
        movieApi: MovieApi,
        movieDetailApi: MovieDetailApi
    ): NavigationProvider {
        return NavigationProvider(movieApi, movieDetailApi)
    }


}