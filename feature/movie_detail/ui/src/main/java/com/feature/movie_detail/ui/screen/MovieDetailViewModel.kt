package com.feature.movie_detail.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_detail.domain.use_case.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _movieDetails = mutableStateOf(MovieDetailStateHolder())
    val movieDetails: State<MovieDetailStateHolder> get() = _movieDetails

    init {
        savedStateHandle.getLiveData<String>("id").observeForever { it ->
            it?.let { id ->
                getMovieDetails(id, "")
            }
        }
    }

    fun getMovieDetails(id: String, apiKey: String) {
        getMovieDetailsUseCase(id, apiKey).onEach {
            when (it) {
                is UiEvent.Success -> {
                    _movieDetails.value = MovieDetailStateHolder(data = it.data)
                }

                is UiEvent.Loading -> {
                    _movieDetails.value = MovieDetailStateHolder(isLoading = true)

                }

                is UiEvent.Error -> {
                    _movieDetails.value = MovieDetailStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}