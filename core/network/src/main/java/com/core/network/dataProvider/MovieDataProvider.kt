package com.core.network.dataProvider

import com.core.network.ApiService
import javax.inject.Inject

class MovieDataProvider @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(apiKey: String, q: String) =
        apiService.getMovieList(apiKey, q)

    suspend fun getMovieDetail(id:String,apiKey: String) =
        apiService.getMovieDetail(id,apiKey)
}