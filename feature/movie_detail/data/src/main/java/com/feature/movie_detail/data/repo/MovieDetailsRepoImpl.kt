package com.feature.movie_detail.data.repo

import com.core.network.dataProvider.MovieDataProvider
import com.feature.movie_detail.data.mappers.toDomain
import com.feature.movie_detail.domain.model.MovieDetails
import com.feature.movie_detail.domain.repository.MovieDetailsRepo
import javax.inject.Inject

class MovieDetailsRepoImpl @Inject constructor(private val movieDataProvider: MovieDataProvider) :
    MovieDetailsRepo {
    override suspend fun getMovieDetailRepo(id: String, apikey: String): MovieDetails {
        return movieDataProvider.getMovieDetail(id, apikey).toDomain()
    }
}