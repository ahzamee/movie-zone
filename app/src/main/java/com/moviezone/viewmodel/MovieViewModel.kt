package com.moviezone.viewmodel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.moviezone.model.moviedetails.MovieDetailsModel
import com.moviezone.remote.MovieInterface
import com.moviezone.util.Events
import com.moviezone.util.Status
import com.moviezone.util.Result
import com.moviezone.view.movie.MoviePaging
import com.moviezone.view.moviedetails.MovieDetailsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieInterface: MovieInterface,
    private val repository: MovieDetailsRepo,
) : ViewModel() {

    private val query = MutableLiveData<String>()

    val list = query.switchMap { query ->
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging(query, movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        query.postValue(s)
    }

    private val _movieDetails = MutableLiveData<Events<Result<MovieDetailsModel>>>()
    val movieDetails: LiveData<Events<Result<MovieDetailsModel>>> = _movieDetails


    fun getMovieDetails(imdbId: String) = viewModelScope.launch {
        _movieDetails.postValue(Events(Result(Status.LOADING, null, null)))
        _movieDetails.postValue(Events(repository.getMovieDetails(imdbId)))
    }
}