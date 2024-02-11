package dev.nermingules.movieappclean.data.repository

import dev.nermingules.movieappclean.data.remote.MovieAPI
import dev.nermingules.movieappclean.data.remote.dto.MovieDetailDto
import dev.nermingules.movieappclean.data.remote.dto.MoviesDto
import dev.nermingules.movieappclean.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImplementation @Inject constructor(private  val api : MovieAPI): MovieRepository {

    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetail(imdbId: String): MovieDetailDto {
        return  api.getMovieDetail(imdbId = imdbId)
    }

}