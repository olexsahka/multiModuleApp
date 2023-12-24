package com.feature.movie_detail.data.mappers

import com.core.network.model.MovieDetailDTO
import com.feature.movie_detail.domain.model.MovieDetails

fun MovieDetailDTO.toDomain(): MovieDetails {
    return MovieDetails(
        title = this.title, description = this.overview, imageUrl = generateUrl(this.poster_path)
    )
}

fun generateUrl(s: String): String =
    "https://image.tmdb.org/t/p/w500/$s"
