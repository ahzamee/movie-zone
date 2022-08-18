package com.moviezone.model.movielist


import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: List<Search>,
    @SerializedName("totalResults")
    val totalResults: String
)