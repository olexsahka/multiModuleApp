package com.feature.movie_detail.domain.repository

import com.feature.movie_detail.domain.model.MovieDetails

interface MovieDetailsRepo {
    suspend fun getMovieDetailRepo(id:String,apikey: String): MovieDetails
}