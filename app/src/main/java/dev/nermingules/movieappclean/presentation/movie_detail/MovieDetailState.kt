package dev.nermingules.movieappclean.presentation.movie_detail

import dev.nermingules.movieappclean.domain.model.MovieDetail

data class MovieDetailState (
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = " "
)
