package com.feature.moview.data.di

import com.core.network.dataProvider.MovieDataProvider
import com.feature.movie.domain.repo.MovieRepository
import com.feature.moview.data.repo.MovieRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepository(movieDataProvider: MovieDataProvider): MovieRepository {
        return MovieRepoImpl(movieDataProvider = movieDataProvider)
    }

}