package com.feature.moview.data.repo

import com.core.network.dataProvider.MovieDataProvider
import com.feature.movie.domain.model.Movie
import com.feature.movie.domain.repo.MovieRepository
import com.feature.moview.data.mapper.toDomainMovieList
import javax.inject.Inject

class MovieRepoImpl @Inject constructor(
    private val movieDataProvider: MovieDataProvider
) : MovieRepository {
    override suspend fun getMovieList(apikey: String, q: String): List<Movie> {
        return movieDataProvider.getMovieList(apikey, q).toDomainMovieList()
    }
}