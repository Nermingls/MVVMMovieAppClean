package dev.nermingules.movieappclean.presentation.movies

import dev.nermingules.movieappclean.data.remote.dto.Search
import dev.nermingules.movieappclean.domain.model.Movie

data class MoviesState (
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search: String = "batman",
)