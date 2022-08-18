package com.moviezone.di

import com.moviezone.remote.MovieInterface
import com.moviezone.util.ApiKeyInterceptor
import com.moviezone.util.Constants
import com.moviezone.view.moviedetails.MovieDetailsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Singleton
    @Provides
    fun retrofitInterface(): MovieInterface {

        val client = OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor())
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BaseUrl).client(client)
            .addConverterFactory(GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }

    @Provides
    fun provideRepository(movieInterface: MovieInterface): MovieDetailsRepo {
        return MovieDetailsRepo(movieInterface)
    }
}