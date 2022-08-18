package com.moviezone.view.moviedetails

import com.moviezone.model.moviedetails.MovieDetailsModel
import com.moviezone.remote.MovieInterface
import com.moviezone.util.Result
import com.moviezone.util.Status

class MovieDetailsRepo(private val movieInterface: MovieInterface) {

    suspend fun getMovieDetails(imdbId: String): Result<MovieDetailsModel> {

        return try {
            val response = movieInterface.getMovieDetails(imdbId)
            if (response.isSuccessful) {
                Result(Status.SUCCESS, data = response.body(), null)
            }else{
                Result(Status.ERROR, data = null, null)
            }
        } catch (e: Exception) {
            Result(Status.ERROR, data = null, null)
        }
    }

}
