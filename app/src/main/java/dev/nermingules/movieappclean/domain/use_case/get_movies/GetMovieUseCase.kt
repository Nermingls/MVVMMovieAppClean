package dev.nermingules.movieappclean.domain.use_case.get_movies

import coil.network.HttpException
import dev.nermingules.movieappclean.data.remote.dto.toMovieList
import dev.nermingules.movieappclean.domain.model.Movie
import dev.nermingules.movieappclean.domain.repository.MovieRepository
import dev.nermingules.movieappclean.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject
//icerisinde tek bir public fonksiyon olur tek ozelligi vardir download/update/delete vs.
class GetMovieUseCase @Inject constructor(private val repository: MovieRepository){
    fun executeGetMovies(search : String) : Flow<Resource<List<Movie>>> = flow {

        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if(movieList.response.equals("True")){
                emit(Resource.Success(movieList.toMovieList()))
            }else {
                emit(Resource.Error(message = "No Movie found"))
            }
        }catch (e : IOException){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e : HttpException){
            emit(Resource.Error(message = "No internet connection"))
        }
    }
}