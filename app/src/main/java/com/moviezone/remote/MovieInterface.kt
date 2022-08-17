package com.moviezone.remote

import com.moviezone.model.movielist.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET()
    suspend fun getAllMovies(
        @Query(value = "s")s: String,
        @Query(value = "page")page: Int
    ): Response<MovieModel>
}