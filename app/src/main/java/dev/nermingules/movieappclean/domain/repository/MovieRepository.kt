package dev.nermingules.movieappclean.domain.repository

import dev.nermingules.movieappclean.data.remote.dto.MovieDetailDto
import dev.nermingules.movieappclean.data.remote.dto.MoviesDto
import dev.nermingules.movieappclean.domain.model.Movie

interface MovieRepository{

    suspend fun getMovies(search : String) : MoviesDto
    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto

}