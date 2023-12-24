package com.example.multimoduleapp.navigation

import com.feature.movie.ui.navigation.MovieApi
import com.feature.movie_detail.ui.navigation.MovieDetailApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailApi: MovieDetailApi
)