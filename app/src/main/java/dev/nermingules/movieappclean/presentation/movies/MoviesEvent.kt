package dev.nermingules.movieappclean.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString: String) : MoviesEvent()
}