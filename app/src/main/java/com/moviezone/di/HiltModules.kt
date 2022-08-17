package com.moviezone.di

import com.moviezone.remote.MovieInterface
import com.moviezone.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    fun retrofitInterface(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constants.BaseUrl).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }
}