package com.feature.movie_detail.ui.screen

import com.feature.movie_detail.domain.model.MovieDetails

data class MovieDetailStateHolder(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)