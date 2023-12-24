package com.feature.movie_detail.domain.use_case

import com.core.common.UiEvent
import com.feature.movie_detail.domain.model.MovieDetails
import com.feature.movie_detail.domain.repository.MovieDetailsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val movieDetailsRepo: MovieDetailsRepo) {
    operator fun invoke(id: String, apikey: String): Flow<UiEvent<MovieDetails>> = flow {
        emit(UiEvent.Loading())
        emit(UiEvent.Success(movieDetailsRepo.getMovieDetailRepo(id, apikey)))

    }.catch {
        emit(UiEvent.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}