package com.feature.movie.domain.di

import com.feature.movie.domain.repo.MovieRepository
import com.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DomainLayerModule {
    @Provides
    fun providesGetMovieListUseCase(movieRepository: MovieRepository): GetMovieListUseCase {
        return GetMovieListUseCase(movieRepository)
    }
}