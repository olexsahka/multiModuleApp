package com.feature.movie.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_case.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MovieSearchViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) :
    ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchStateHolder())
    val movieList: State<MovieSearchStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    fun setQuery(s: String) {
        _query.value = s
    }

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(
                    "",
                    it
                )
            }
        }
    }

    fun getMovieList(apikey: String, q: String) = viewModelScope.launch {
        getMovieListUseCase(apikey, q).onEach {
            when (it) {
                is UiEvent.Loading -> _movieList.value = MovieSearchStateHolder(
                    isLoading = true,
                )

                is UiEvent.Success -> _movieList.value = MovieSearchStateHolder(
                    data = it.data,
                )

                is UiEvent.Error -> _movieList.value = MovieSearchStateHolder(
                    error = "Nothing to show"
                )
            }
        }.launchIn(viewModelScope)

    }

}