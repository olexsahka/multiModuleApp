package com.core.network

import com.core.network.model.MovieDetailDTO
import com.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("3/search/movie")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("query") q: String
    ):MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String
    ) : MovieDetailDTO
}