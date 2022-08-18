package com.moviezone.remote

import com.moviezone.model.movielist.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("/")
    suspend fun getAllMovies(
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String
    ): Response<MovieModel>
}