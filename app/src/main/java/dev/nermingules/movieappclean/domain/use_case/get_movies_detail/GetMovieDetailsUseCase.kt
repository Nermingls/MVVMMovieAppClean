package dev.nermingules.movieappclean.domain.use_case.get_movies_detail

import coil.network.HttpException
import dev.nermingules.movieappclean.data.remote.dto.toMovieDetail
import dev.nermingules.movieappclean.data.remote.dto.toMovieList
import dev.nermingules.movieappclean.domain.model.Movie
import dev.nermingules.movieappclean.domain.model.MovieDetail
import dev.nermingules.movieappclean.domain.repository.MovieRepository
import dev.nermingules.movieappclean.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository){
    fun executeGetMovieDetails(imdbId : String) : Flow<Resource<MovieDetail>> = flow {

        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetail(imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        }catch (e : IOException){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e : HttpException){
            emit(Resource.Error(message = "No internet connection"))
        }

    }
}