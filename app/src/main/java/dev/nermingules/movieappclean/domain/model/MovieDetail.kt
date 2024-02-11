package dev.nermingules.movieappclean.domain.model

import com.google.gson.annotations.SerializedName
import dev.nermingules.movieappclean.data.remote.dto.Rating

data class MovieDetail(
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("imdbVotes")
    val imdbVotes: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Rated")
    val rated: String,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Response")
    val response: String,
    @SerializedName("Runtime")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String
)
