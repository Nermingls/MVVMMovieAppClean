package dev.nermingules.movieappclean.presentation.movies

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nermingules.movieappclean.data.remote.dto.Search
import dev.nermingules.movieappclean.domain.use_case.get_movies.GetMovieUseCase
import dev.nermingules.movieappclean.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel  @Inject constructor(
    private val getMovieUseCase : GetMovieUseCase
) : ViewModel(){

    private val _state = mutableStateOf<MoviesState>(MoviesState())
    val state : State<MoviesState> = _state

    private var job : Job? = null
    init {
        getMovies(_state.value.search)
    }

    private fun getMovies(search: String){
        job?.cancel()
        job = getMovieUseCase.executeGetMovies(search = search).onEach {
           when(it){
               is  Resource.Success -> {
                   _state.value = MoviesState(movies = it.data ?: emptyList())
               }
               is Resource.Error -> {
                   _state.value = _state.value.copy(error = it.message ?: "Error! ")//farki yeni intensce olusturmadan Moviestate olanla ayni islev
               }
               is Resource.Loading -> {
                   _state.value = MoviesState(isLoading = true)
               }
           }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: MoviesEvent) {
        when(event) {
            is MoviesEvent.Search -> {
                getMovies(event.searchString)
            }
        }
    }
}
