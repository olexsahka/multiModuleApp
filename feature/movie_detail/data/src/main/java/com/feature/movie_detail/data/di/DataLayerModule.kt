package com.feature.movie_detail.data.di

import com.core.network.dataProvider.MovieDataProvider
import com.feature.movie_detail.data.repo.MovieDetailsRepoImpl
import com.feature.movie_detail.domain.repository.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideMovieRepository(movieDataProvider: MovieDataProvider): MovieDetailsRepo {
        return MovieDetailsRepoImpl(movieDataProvider = movieDataProvider)
    }

}