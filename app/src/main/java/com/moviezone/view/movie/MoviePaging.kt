package com.moviezone.view.movie

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moviezone.model.movielist.Search
import com.moviezone.remote.MovieInterface
import com.moviezone.util.Constants

class MoviePaging(val s: String, val movieInterface: MovieInterface) : PagingSource<Int, Search>() {

    override fun getRefreshKey(state: PagingState<Int, Search>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Search> {
        val page = params.key ?: 1

        return try {

            val data = movieInterface.getAllMovies(s, page)

            Log.d("aaaaa", "load: ${data.body()?.totalResults}")

            LoadResult.Page(
                data = data.body()?.search!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.body()?.search?.isEmpty()!!) null else page + 1
            )

        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }

    }
}