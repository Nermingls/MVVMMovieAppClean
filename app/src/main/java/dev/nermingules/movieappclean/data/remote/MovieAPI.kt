package dev.nermingules.movieappclean.data.remote

import dev.nermingules.movieappclean.data.remote.dto.MovieDetailDto
import dev.nermingules.movieappclean.data.remote.dto.MoviesDto
import dev.nermingules.movieappclean.data.remote.dto.Search
import dev.nermingules.movieappclean.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    //https://www.omdbapi.com/?apikey=ee10c685&s=batman
    //https://www.omdbapi.com/?apikey=ee10c685&i=tt0372784

    @GET(".")
    suspend fun  getMovies(
        @Query("s") searchString: String,
        @Query("apikey") apiKey : String = API_KEY



    ):MoviesDto//ne dondurdugunu gosteriyoruz

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId: String,
        @Query("apikey") apiKey : String = API_KEY
    ):MovieDetailDto//ne dondurdugunu gosteriyoruz
}