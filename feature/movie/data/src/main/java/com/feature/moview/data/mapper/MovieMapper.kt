package com.feature.moview.data.mapper

import com.core.network.model.MovieListResponse
import com.feature.movie.domain.model.Movie

fun MovieListResponse.toDomainMovieList(): List<Movie> {
    return this.results.map {
        Movie(imgUrl = generateUrl(it.poster_path),id =it.id.toString())
    }
}

fun generateUrl(s: String) : String =
     "https://image.tmdb.org/t/p/w500/$s"
