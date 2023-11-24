package com.example.pagingcompose.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingcompose.data.model.Movie

internal class MovieDataSource(
    private val apiHelper: ApiService = RetrofitBuilder.apiService,
) : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
//        return ( (state.anchorPosition ?: 0) - state.config.initialLoadSize / 2).coerceAtLeast(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> = try {
        //Starting on page 1 per endpoint requirement, page 0 doesn't exist
        val pageToLoad = params.key ?: 1
        Log.d("pageToLoad", "pageToLoad: $pageToLoad")

        val limit = params.loadSize
        val titleResponse = apiHelper.getTitles(pageToLoad, limit)
        //Because of SUCCESS code even when an error code should be returned
        titleResponse.error?.let {
            Log.e("MovieDataSource", it)
            LoadResult.Error(Exception(it))
        } ?: run {
            val titles = titleResponse.results
            val isFirstPage = pageToLoad == 1
            val isLastPage = titles.isEmpty() || titles.size < limit
            LoadResult.Page(
                data = titles,
                prevKey = if (isFirstPage) null else pageToLoad - 1,
                nextKey = if (isLastPage) null else pageToLoad + 1,
            )
        }
    } catch (exception: Exception) {
        Log.e("MovieDataSource", exception.message.orEmpty())
        LoadResult.Error(exception)
    }
}