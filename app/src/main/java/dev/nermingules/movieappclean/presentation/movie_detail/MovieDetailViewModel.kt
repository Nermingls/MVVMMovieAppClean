package dev.nermingules.movieappclean.presentation.movie_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nermingules.movieappclean.domain.use_case.get_movies.GetMovieUseCase
import dev.nermingules.movieappclean.domain.use_case.get_movies_detail.GetMovieDetailsUseCase
import dev.nermingules.movieappclean.utils.Constants.IMDB_ID
import dev.nermingules.movieappclean.utils.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private  val getMovieDetailsUseCase:  GetMovieDetailsUseCase,
    private val stateHandle : SavedStateHandle
) : ViewModel() {
    private  val _state = mutableStateOf<MovieDetailState>(MovieDetailState())
    val state : State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
        }

    }
    private fun getMovieDetail(imdbId : String) {
        getMovieDetailsUseCase.executeGetMovieDetails(imdbId = imdbId).onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(movie = it.data)
                }
                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "E")
                }
                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}